package com.infodart.peerhuntr.jpa.service.Impl;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infodart.peerhuntr.constants.Constants;
import com.infodart.peerhuntr.dto.peerRating.RatingTypeDTO;
import com.infodart.peerhuntr.dto.peerRating.UserAvgRatingDTO;
import com.infodart.peerhuntr.dto.peerRating.UserRatingDTO;
import com.infodart.peerhuntr.dto.personalityTest.AnswerMasterDTO;
import com.infodart.peerhuntr.dto.personalityTest.PersonalityMasterDTO;
import com.infodart.peerhuntr.dto.request.RequestDTO;
import com.infodart.peerhuntr.dto.response.ResponseDTO;
import com.infodart.peerhuntr.dto.user.DegreeMasterDTO;
import com.infodart.peerhuntr.dto.user.NationalityMasterDTO;
import com.infodart.peerhuntr.dto.user.ProfileImageDTO;
import com.infodart.peerhuntr.dto.user.SpecializationMasterDTO;
import com.infodart.peerhuntr.dto.user.UserDTO;
import com.infodart.peerhuntr.dto.user.UserLoginDTO;
import com.infodart.peerhuntr.jpa.dao.UserCartDao;
import com.infodart.peerhuntr.jpa.dao.UserDao;
import com.infodart.peerhuntr.jpa.dao.UserDetailsDao;
import com.infodart.peerhuntr.jpa.entity.peerRating.RatingType;
import com.infodart.peerhuntr.jpa.entity.personalityTest.PersonalityMaster;
import com.infodart.peerhuntr.jpa.entity.user.AuthorityMaster;
import com.infodart.peerhuntr.jpa.entity.user.CustomUser;
import com.infodart.peerhuntr.jpa.entity.user.DegreeMaster;
import com.infodart.peerhuntr.jpa.entity.user.NationalityMaster;
import com.infodart.peerhuntr.jpa.entity.user.ProfileImage;
import com.infodart.peerhuntr.jpa.entity.user.SpecializationMaster;
import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.jpa.entity.user.UserLogin;
import com.infodart.peerhuntr.mapper.DozerMapping;
import com.infodart.peerhuntr.propertyloader.PropertyLoader;
import com.infodart.peerhuntr.spring.controller.HomeController;
import com.infodart.peerhuntr.spring.mail.MailSender;
import com.infodart.peerhuntr.util.AppUtil;
import com.infodart.peerhuntr.util.ForkBlur;

@Service
@Transactional
@PropertySource("classpath:messages.properties")
public class UserServiceImpl implements UserService {

	/**
	 * Register user
	 */
	// final static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserDetailsDao userDetailsDao;

	@Autowired
	UserCartDao userCartDAO;
	private DozerMapping mapper;

	String path;

	// String path="D://images";

	/*
	 * public ResponseDTO login(UserLoginDTO userLoginDTO) { User user = null;
	 * ResponseDTO response=new ResponseDTO(); boolean isEmailExist = false; try {
	 * isEmailExist = userDao.checkEmailIdExistence(userLoginDTO); if(isEmailExist)
	 * { UserLogin userLogin=userDao.getUserLogin(userLoginDTO);
	 * 
	 * 
	 * boolean passworMatches=new
	 * BCryptPasswordEncoder().matches(userLoginDTO.getLoginPassword(),
	 * userLogin.getLoginPassword()); if(passworMatches==true) {
	 * response.setStatus(Constants.SUCCESS_STATUS);
	 * response.setStatusCode(Constants.SUCCESS_STATUS_CODE);
	 * response.setMessage("Login Successfully");
	 * 
	 * 
	 * userDao.fetchUser(userLogin.getUserLoginId()); }else {
	 * response.setStatus(Constants.FAILURE_STATUS);
	 * response.setStatusCode(Constants.FAILURE_STATUS_CODE);
	 * response.setMessage("Password is wrong"); }
	 * 
	 * } else { response.setStatus(Constants.FAILURE_STATUS);
	 * response.setStatusCode(Constants.FAILURE_STATUS_CODE);
	 * response.setMessage("Email id doesnt exist"); }
	 * 
	 * }catch(Exception e) { response.setStatus(Constants.FAILURE_STATUS);
	 * response.setStatusCode(Constants.FAILURE_STATUS_CODE);
	 * response.setErrorMsg("User cannot login as "+e.getMessage());
	 * 
	 * } return response; }
	 */

	@Override
	public ResponseDTO registerUser(UserDTO userDTO, HttpServletRequest request) {

		User user = null;
		ResponseDTO response = new ResponseDTO();
		boolean isEmailExist = false;
		try {

			// String currentTime = sdf.format(dt);
			isEmailExist = userDao.checkEmailIdExistence(userDTO.getUserLogin());
			if (!isEmailExist) {

				if (userDTO.getStringDateOfBirth() != null)
					userDTO.setDateOfBirth(AppUtil.getDate(userDTO.getStringDateOfBirth()));

				/** Set profile image data **/
				Set<ProfileImageDTO> profileImages = new HashSet<ProfileImageDTO>();

				ProfileImageDTO profileImageDTO = new ProfileImageDTO();
				profileImageDTO.setImageUrl("NA");
				profileImageDTO.setHiddenImageUrl("NA");
				profileImageDTO.setCreatedOn(AppUtil.getCurrentDate());
				profileImageDTO.setModifiedOn(AppUtil.getCurrentDate());
				profileImages.add(profileImageDTO);
				userDTO.setProfileImages(profileImages);

				/** end of setting profile image data **/

				userDTO.getUserLogin().setLoginPassword(
						new BCryptPasswordEncoder().encode(userDTO.getUserLogin().getLoginPassword()));

				String token = UUID.randomUUID().toString();
				user = (User) mapper.convert(userDTO, user, User.class);
				user.setUserToken(token);
				user.setStatus((byte) 0);
				user.setExpirydate(calculateExpiryDate(Constants.EXPIRATION));
				user.setCreatedOn(AppUtil.getCurrentDate());
				user.setModifiedOn(AppUtil.getCurrentDate());

				if (user.getUserInterface() == null || user.getUserInterface().isEmpty())
					user.setUserInterface(Constants.USER_INTERFACE_WEB);

				AuthorityMaster authorityMaster = new AuthorityMaster();
				authorityMaster.setAuthorityId(2);

				user.getUserLogin().setCreatedOn(AppUtil.getCurrentDate());
				user.getUserLogin().setModifiedOn(AppUtil.getCurrentDate());
				user.getUserLogin().setStatus((byte) 0);
				user.getUserLogin().setAuthorityMaster(authorityMaster);
				user.getUserLogin().setLoginAttempts((byte) 1);

				userDao.saveOrUpdate(user);

				sendRegistrationTokenMail(token, user.getUserLogin().getLoginId(),user.getFirstName());

			} else {
				response.setStatus(Constants.FAILURE_STATUS);
				response.setStatusCode(Constants.FAILURE_STATUS_CODE);
				response.setErrorMsg(Constants.EMAIL_EXISTS);
			}
		} catch (Exception e) {
			response.setStatus(Constants.FAILURE_STATUS);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			response.setErrorMsg("User can't be saved " + e.getMessage());
			e.printStackTrace();

		}
		return response;
	}

	/** Save user data in profileImage and also update referral code **/
	@Override
	public boolean saveRegisterImage(UserDTO userDTO, HttpServletRequest request) {
		boolean imageSaved=false;
		try {

			User user = userDetailsDao.fetchUser(userDTO.getUserLogin().getLoginId());
			updateReferralCode(user);

			int profileId = 0;

			Set<ProfileImage> profileImages = user.getProfileImages();
			for (ProfileImage p : profileImages) {
				/*
				 * encodeBase64 = Base64.encodeBase64(p.getImage());
				 * userDTO.setBase64Encoded(new String(encodeBase64, "UTF-8"));
				 * 
				 */
				profileId = p.getProfileImageId();

			}
			imageSaved=saveRegisterImageDb(userDTO.getImageInBytes(), user.getUserId(), profileId, request);

			if(imageSaved==false)
				userDao.delete(user);

			return imageSaved;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageSaved;
	}

	public void updateReferralCode(User user) {
		try {
			String random = RandomStringUtils.random(8, true, true);
			user.setReferralCode(user.getUserId() + random);
			userDao.updateReferralCode(user);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public byte[] getBlurImage(byte[] image) {

		byte[] bytes = null;
		try {
			// convert byte array back to BufferedImage
			InputStream in = new ByteArrayInputStream(image);
			BufferedImage bImageFromConvert = ImageIO.read(in);

			BufferedImage blurImage;
			blurImage = ForkBlur.blur(bImageFromConvert);
			// blurImage=blurImage(bImageFromConvert);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(blurImage, "jpg", baos);
			bytes = baos.toByteArray();

			/*
			 * Iterator i = ImageIO.getImageReaders(in); if (i.hasNext()) {
			 * System.out.println("Reader is found");
			 * 
			 * } else { System.out.println("Reader is not found");
			 * 
			 * }
			 * 
			 * if (bImageFromConvert == null) { System.out.println("Image is NULL");
			 * 
			 * }
			 * 
			 * 
			 * 
			 * 
			 * 
			 * ImageIO.write(bImageFromConvert, "jpg", new File("D:\\IMAGE.jpg"));
			 * ImageIO.write(blurImage, "jpg", new File("D:\\blur.jpg"));
			 * 
			 * System.out.println("image created successfully");
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bytes;
	}

	public BufferedImage blurImage(BufferedImage image) {
		float ninth = 1.0f / 9.0f;
		float[] blurKernel = { ninth, ninth, ninth, ninth, ninth, ninth, ninth, ninth, ninth };

		Map<RenderingHints.Key, Object> map = new HashMap<RenderingHints.Key, Object>();
		map.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		map.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		map.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		RenderingHints hints = new RenderingHints(map);
		BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, blurKernel), ConvolveOp.EDGE_NO_OP, hints);

		return op.filter(image, null);
	}

	private static int[] getSurroundingPixels(BufferedImage bi, int startx, int endx, int starty, int endy) {
		int pix[] = new int[(endx + 1 - startx) * (endy + 1 - starty)];
		for (int i = startx, index = 0; i <= endx; i++)
			for (int j = starty; j <= endy; j++)
				pix[index++] = bi.getRGB(i, j);
		return pix;
	}

	@Override
	public String validateVerificationToken(String token) {

		UserDTO userDTO = new UserDTO();

		final User user = userDao.findByToken(token);
		if (user == null) {
			return Constants.TOKEN_INVALID;
		}

		// final User user = verificationToken.getUserId();
		final Calendar cal = Calendar.getInstance();
		if ((user.getExpirydate().getTime() - cal.getTime().getTime()) <= 0) {
			generateToken(user);
			return Constants.TOKEN_EXPIRED;
		}
		user.setEmailVerified((byte) 1);
		userDao.save(user);
		return Constants.TOKEN_VALID;

	}

	public void generateToken(User user) {
		try {
			String token = UUID.randomUUID().toString();
			user.setUserToken(token);
			user.setStatus((byte) 0);
			user.setExpirydate(calculateExpiryDate(Constants.EXPIRATION));
			user.setModifiedOn(AppUtil.getCurrentDate());
			userDao.save(user);
			sendRegistrationTokenMail(token, user.getUserLogin().getLoginId(),user.getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sendRegistrationTokenMail(String token, String email,String name) {
		String recep = email;
		String bodyText = "Dear " + name + ",<br/><br/>" 
				+ "  Thank you for registering your profile on peerHuntr.<br/><br/>"
				+ "	Please click on the following link to confirm your e-mail address:<br/><br/>";
		bodyText = bodyText + PropertyLoader.getInstance().PROJECT_LINK + "registrationConfirm?token=" + token;
		bodyText = bodyText + "<br/><br/>Best regards,<br/><br/>" + "		peerHuntr<br/><br/>" + "";
		new MailSender(recep, null, PropertyLoader.getInstance().CONFIRM_REGISTRATION_SUBJECT, bodyText);
	}

	public User getUser(String token) {
		final User user = userDao.findByToken(token);
		return user;
	}

	@Override
	public List<Object> getDegree() {

		DegreeMasterDTO degreeMasterDTOs = null;
		List<Object> degreeMasterDTOlist = new ArrayList<Object>();
		List<DegreeMaster> daDegreeMasters = userDao.findAllDegree();
		for (DegreeMaster dMaster : daDegreeMasters) {
			degreeMasterDTOlist.add((DegreeMasterDTO) mapper.convert(dMaster, degreeMasterDTOs, DegreeMasterDTO.class));
		}
		return degreeMasterDTOlist;

	}

	@Override
	public List<Object> getNationality() {

		NationalityMasterDTO nationalityMasterDTOs = null;
		List<Object> nationalityMasterDTOlist = new ArrayList<>();

		List<NationalityMaster> nationalityMaster = userDao.findAllNationality();
		for (NationalityMaster nMaster : nationalityMaster) {
			nationalityMasterDTOlist.add(
					(NationalityMasterDTO) mapper.convert(nMaster, nationalityMasterDTOs, NationalityMasterDTO.class));
		}
		return nationalityMasterDTOlist;
	}

	@Override
	public List<Object> getSpecialization() {
		// TODO Auto-generated method stub

		SpecializationMasterDTO specializationMasterDTOs = null;
		List<Object> specializationMasterDTOlist = new ArrayList<>();

		List<SpecializationMaster> specializationMaster = userDao.findAllSpecialization();

		for (SpecializationMaster sMasterr : specializationMaster) {

			specializationMasterDTOlist.add((SpecializationMasterDTO) mapper.convert(sMasterr, specializationMasterDTOs,
					SpecializationMasterDTO.class));
		}
		return specializationMasterDTOlist;

	}

	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

	@Override
	public ResponseDTO updateForgetPassword(UserLoginDTO userLoginDTO) {

		ResponseDTO response = new ResponseDTO();
		try {

			int userLoginId = userDao.getUserLoginIdByReferralCode(userLoginDTO.getReferralCode());

			userLoginDTO.setLoginPassword(new BCryptPasswordEncoder().encode(userLoginDTO.getNewPassword()));
			userLoginDTO.setUserLoginId(userLoginId);
			userDao.changePassword(userLoginDTO);

			response.setStatus(Constants.SUCCESS_STATUS);
			response.setStatusCode(Constants.SUCCESS_STATUS_CODE);
			response.setMessage("Password changed successfully");

		} catch (Exception e) {
			response.setStatus(Constants.FAILURE_STATUS);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			response.setErrorMsg("Password cannot be changed as " + e.getMessage());

		}

		return response;

	}

	@Override
	public ResponseDTO changePassword(UserLoginDTO userLoginDTO) {

		ResponseDTO response = new ResponseDTO();
		try {
			if (userLoginDTO.getUserLoginId() == 0) {
				userLoginDTO.setUserLoginId(userDao.getUserLoginIdByEmail(HomeController.getPrincipal()));
			}

			/*
			 * if(userLoginDTO.getLoginId()==null || userLoginDTO.getLoginId().isEmpty()) {
			 * userLoginDTO.setLoginId(HomeController.getPrincipal());
			 * 
			 * }
			 */

			if (userLoginDTO.getUserLoginId() != 0) {
				UserLogin userLogin = userDao.getUserLogin(userLoginDTO);
				boolean passwordMatch = new BCryptPasswordEncoder().matches(userLoginDTO.getOldPassword(),
						userLogin.getLoginPassword());

				if (passwordMatch == true) {
					userLoginDTO.setLoginPassword(new BCryptPasswordEncoder().encode(userLoginDTO.getNewPassword()));
					userDao.changePassword(userLoginDTO);
					response.setStatus(Constants.SUCCESS_STATUS);
					response.setStatusCode(Constants.SUCCESS_STATUS_CODE);
					response.setMessage("Password changed successfully");
				} else {
					response.setStatus(Constants.FAILURE_STATUS);
					response.setStatusCode(Constants.FAILURE_STATUS_CODE);
					response.setErrorMsg("Old password doesn't match");
				}
			}

		} catch (Exception e) {
			response.setStatus(Constants.FAILURE_STATUS);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			response.setErrorMsg("Password cannot be changed as " + e.getMessage());

		}

		return response;

	}

	public String getUsername() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			return authentication.getName();

		}
		return null;
	}

	public ResponseDTO forgetPassword(UserLoginDTO userLoginDTO) {
		ResponseDTO response = new ResponseDTO();
		try {
			// String password=RandomStringUtils.random(8,true,true);

			// String password="Peerhuntr@123";
			boolean emailIdExists = userDao.checkEmailIdExistence(userLoginDTO);
			if (emailIdExists == true) {
				User user = userDao.getReferralCode(userLoginDTO);
				String referralCode = user.getReferralCode();

				// userLoginDTO.setLoginPassword(new BCryptPasswordEncoder().encode(password));
				// userDao.forgetPassword(userLoginDTO);

				String bodyText = "Dear " + user.getFirstName() +",<br/><br/>"
						+ "		We have received a request to reset your password.<br/><br/>"
						+ "If you have not generated this request or if you have remembered your password since your request to reset it, please ignore this message.<br/><br/>"
						+ "If you would like to create a new password, please click on the following link:<br/>" + ""
						+ PropertyLoader.getInstance().PROJECT_LINK + "updateForgetPassword?referralCode="
						+ referralCode;
				bodyText = bodyText +

						new MailSender(userLoginDTO.getLoginId(), null,
								PropertyLoader.getInstance().FORGET_PASSWORD_SUBJECT, bodyText);

				response.setStatus(Constants.SUCCESS_STATUS);
				response.setStatusCode(Constants.SUCCESS_STATUS_CODE);
				response.setMessage("Password link is mailed on registered mail id");
			} else {
				response.setStatus(Constants.FAILURE_STATUS);
				response.setStatusCode(Constants.FAILURE_STATUS_CODE);
				response.setErrorMsg("Email id is not registered");
			}

		} catch (Exception e) {
			response.setStatus(Constants.FAILURE_STATUS);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			response.setErrorMsg("Password cannot be changed as " + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public ResponseDTO fetchAllUserProfile() {
		UserDTO userDTO = null;
		ResponseDTO response = new ResponseDTO();
		List<Object> responseList = new ArrayList<>();
		String iMAGE_PATH = PropertyLoader.iSelf.IMAGE_PATH;
		try {
			String base64Encoded = null, base64EncodedBlur = null;
			List<Object> users = userDao.fetchAllUserProfile();
			Iterator itr = users.iterator();

			while (itr.hasNext()) {
				User user = (User) itr.next();
				userDTO = (UserDTO) mapper.convert(user, userDTO, UserDTO.class);

				/*
				 * Set<ProfileImage> profileImages=user.getProfileImages(); for(ProfileImage
				 * p:profileImages) { byte[] encodeBase64 = Base64.encodeBase64(p.getImage());
				 * userDTO.setBase64Encoded(new String(encodeBase64, "UTF-8"));
				 * 
				 * encodeBase64 = Base64.encodeBase64(p.getHiddenImage());
				 * userDTO.setBase64EncodedBlur(new String(encodeBase64, "UTF-8"));
				 * p.setImageUrl(iMAGE_PATH.concat(p.getImageUrl()));
				 * p.setHiddenImageUrl(iMAGE_PATH.concat(p.getHiddenImageUrl()));
				 * saveImage(p.getImage()); }
				 */

				Set<ProfileImageDTO> profileImageDTOs = userDTO.getProfileImages();
				for (ProfileImageDTO p : profileImageDTOs) {

					p.setImageUrl(PropertyLoader.iSelf.IMAGE_PATH + "" + p.getImageUrl());
					p.setHiddenImageUrl(PropertyLoader.iSelf.IMAGE_PATH + "" + p.getHiddenImageUrl());

					System.out.println(p.getHiddenImageUrl());
				}
				userDTO.setProfileImages(profileImageDTOs);

				userDTO.setAge(getAge(userDTO.getDateOfBirth()));
				responseList.add(userDTO);

			}
			response.setResponseList(responseList);

		} catch (Exception e) {
			response.setStatus(Constants.FAILURE_STATUS);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			response.setErrorMsg("User data cannot be fetched as " + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	public boolean saveRegisterImageDb(byte[] image, int id, int profileImageId, HttpServletRequest request) {

		try {

			path = AppUtil.getContextPath(request);

			// path="d:\\images";

			String imagePath = id + "_image"+AppUtil.getImageCurrentDateString()+".jpg";
			String blurImagePath = id + "_blur_image"+AppUtil.getImageCurrentDateString()+".jpg";
			// convert byte array back to BufferedImage
			InputStream in = new ByteArrayInputStream(image);
			BufferedImage bImageFromConvert = ImageIO.read(in);
			Iterator i = ImageIO.getImageReaders(in);

			BufferedImage outputImage = getResizedImage(bImageFromConvert);

			ImageIO.write(outputImage, "jpg", new File(path + "//" + imagePath));

			in = new ByteArrayInputStream(getBlurImage(image));
			bImageFromConvert = ImageIO.read(in);
			outputImage = getResizedImage(bImageFromConvert);
			ImageIO.write(outputImage, "jpg", new File(path + "//" + blurImagePath));

			userDao.updateProfileImageURL(imagePath, blurImagePath, profileImageId);

			System.out.println("image created successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private BufferedImage getResizedImage(BufferedImage inputImage) {
		int scaledWidth = 540, scaledHeight = 540;
		BufferedImage outputImage = null;
		try {
			outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());
			Graphics2D g2d = outputImage.createGraphics();
			g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
			g2d.dispose();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return outputImage;
	}

	/*public  void saveImage(byte[] image) {
		try {
			// convert byte array back to BufferedImage
			InputStream in = new ByteArrayInputStream(image);
			BufferedImage bImageFromConvert = ImageIO.read(in);

			Iterator i = ImageIO.getImageReaders(in);
			if (i.hasNext()) {
				System.out.println("Reader is found");
			} else {
				System.out.println("Reader is not found");
			}
			if (bImageFromConvert == null) {
				System.out.println("Image is NULL");
			}
			ImageIO.write(bImageFromConvert, "jpg", new File("D:\\IMAGE1.jpg"));
			BufferedImage blurImage=blurImage(bImageFromConvert);
			ImageIO.write(blurImage, "jpg", new File("D:\\blur_new.jpg"));
			blurImage(bImageFromConvert);
			System.out.println("image created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}*/

	public static int getAge(Date dob) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		LocalDate curDate = LocalDate.now();
		return Period.between(LocalDate.parse(sdf.format(dob)), curDate).getYears();
	}

	@Autowired
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public ResponseDTO getSpecializationOnDegree(SpecializationMasterDTO specializationMasterDTO) {

		ResponseDTO response = new ResponseDTO();
		List<Object> responseList = new ArrayList<Object>();

		SpecializationMasterDTO specializationMasterDTOs = null;
		List<Object> specializationMasterDTOlist = new ArrayList<>();

		List<SpecializationMaster> specializationMaster = userDao.getSpecializationOnDegree(specializationMasterDTO);
		for (SpecializationMaster sMasterr : specializationMaster) {
			specializationMasterDTOlist.add((SpecializationMasterDTO) mapper.convert(sMasterr, specializationMasterDTOs,
					SpecializationMasterDTO.class));
		}
		response.setResponseList(specializationMasterDTOlist);
		return response;
	}

	@Override
	public ResponseDTO fetchUsersCard(RequestDTO resquestDTO) {

		UserDTO userDTO = null;
		ResponseDTO response = new ResponseDTO();

		int startFirstResult = (resquestDTO.getPageNo() - 1) * Constants.PAGE_DATA;
		int startMaxResult = Constants.PAGE_DATA;
		int userID=0;

		/* ******* authenticated user ******************** */

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getPrincipal().equals("anonymousUser")) {
			userID=0;
		}else {
			CustomUser customUser = (CustomUser) auth.getPrincipal();
			userID = customUser.getUserId();
		}

		/* *********** */

		try {

			/**************************************
			 * Get User List Without Parameter
			 ******************************************/

			if (resquestDTO.getNationalityData()==null || 
					resquestDTO.getSpecializationData()==null||
					resquestDTO.getPersonalityData()==null||
					resquestDTO.getDegreeData()==null && 
					resquestDTO.getSortByRating() == null) {
				List<Object[]> users = userDao.fetchUsersCardWithoutParameter(resquestDTO, startFirstResult,
						startMaxResult,userID);
				response = getUserFilterTransformInDTO(users);
				response.setTotalPage(userDao.fetchUsersCardWithoutParameterCount(resquestDTO,userID));

			}
			if ((resquestDTO.getNationalityData()!=null || 
					resquestDTO.getSpecializationData()!=null||
					resquestDTO.getPersonalityData()!=null||
					resquestDTO.getDegreeData()!=null) && resquestDTO.getSortByRating()==null) {	
				List<Object[]> users = userDao.getUserList(resquestDTO.getNationalityData(),resquestDTO.getSpecializationData(),resquestDTO.getPersonalityData(),resquestDTO.getDegreeData(),
						 startFirstResult, startMaxResult,userID);


				response = getUserFilterTransformInDTO(users);
				response.setTotalPage(userDao.getUserListCount(resquestDTO.getNationalityData(),resquestDTO.getSpecializationData(),resquestDTO.getPersonalityData(),resquestDTO.getDegreeData(),userID));

			}else if(resquestDTO.getNationalityData()!=null || 
					resquestDTO.getSpecializationData()!=null||
					resquestDTO.getPersonalityData()!=null||
					resquestDTO.getDegreeData()!=null && 
					resquestDTO.getSortByRating() != null) {
				List<Object[]> usersSort = userDao.getUsersListSortByRating(resquestDTO.getNationalityData(),resquestDTO.getSpecializationData(),resquestDTO.getPersonalityData(),resquestDTO.getDegreeData(),
						resquestDTO.getSortByRating(), startFirstResult, startMaxResult,userID);
				response = getUserFilterTransformInDTO(usersSort);
				response.setTotalPage(userDao.getCountUsersListSortByRating(resquestDTO.getNationalityData(),resquestDTO.getSpecializationData(),resquestDTO.getPersonalityData(),resquestDTO.getDegreeData(),
						resquestDTO.getSortByRating(),userID));
			}
			/*	if (resquestDTO
					.getFilterParamter() != null) { *//************** Get User List with Parameter ********************//*
					 */
			/*if (resquestDTO.getFilterParamter().equalsIgnoreCase(Constants.degree) //By Degree and Degree with Rating value
						&& resquestDTO.getFilterParamter() != null) {

					if (resquestDTO.getSortByRating()==null) {
						List<Object[]> usersObject = userDao.getUserList(resquestDTO.getNationalityData(),resquestDTO.getSpecializationData(),resquestDTO.getPersonalityData(),resquestDTO.getDegreeData(),
								resquestDTO.getSortByRating(), startFirstResult, startMaxResult,userID);
						response = getUserFilterTransformInDTO(usersObject);
						response.setTotalPage(userDao.getCountUserByDegree(resquestDTO.getKeyname(),userID));
						response.setStatus(Constants.SUCCESS_STATUS);
						response.setStatusCode(Constants.SUCCESS_STATUS_CODE);


					} else {

						List<Object[]> usersObject = userDao.getUserSortByRatingAndByDegreeList(resquestDTO.getKeyname(),
								resquestDTO.getSortByRating(), startFirstResult, startMaxResult,userID);
						response = getUserFilterTransformInDTO(usersObject);
						response.setTotalPage(userDao.getCountUserSortByRatingAndByDegreeList(resquestDTO.getKeyname(),
								resquestDTO.getSortByRating(),userID));
						response.setStatus(Constants.SUCCESS_STATUS);
						response.setStatusCode(Constants.SUCCESS_STATUS_CODE);
                    	}

				} else if (resquestDTO.getFilterParamter().equalsIgnoreCase(Constants.personalityType) //By Personality Type and Persoanality Type with Rating 
						&& resquestDTO.getFilterParamter() != null) { // Get PersonalityType

					if (resquestDTO.getSortByRating()==null) {
						List<Object[]> users = userDao.getUserByPersonalityMasterList(resquestDTO.getKeyname(), "0",
								startFirstResult, startMaxResult,userID);
						response = getUserFilterTransformInDTO(users);
						response.setTotalPage(userDao.getCountUserByPersonality(resquestDTO.getKeyname(),userID));
					} else {

						List<Object[]> users = userDao.getUserSortByRatingAndByPersonalityMasterList(resquestDTO.getKeyname(), resquestDTO.getSortByRating(),
								startFirstResult, startMaxResult,userID);
						response = getUserFilterTransformInDTO(users);
						response.setTotalPage(userDao.getCountUserSortByRatingAndByPersonalityMasterList(resquestDTO.getKeyname(),resquestDTO.getSortByRating(),userID));

					}

					response.setStatus(Constants.SUCCESS_STATUS);
					response.setStatusCode(Constants.SUCCESS_STATUS_CODE);

				} else if (resquestDTO.getFilterParamter().equalsIgnoreCase(Constants.specialization)  //By sepecilization and specialization with rating
						&& resquestDTO.getFilterParamter() != null) { // Specialization

					if (resquestDTO.getSortByRating()==null) {
						List<Object[]> users = userDao.getUserBySpecialization(resquestDTO.getKeyname(), "0",
								startFirstResult, startMaxResult,userID);
						response = getUserFilterTransformInDTO(users);
						response.setTotalPage(userDao.getCountUserBySpecialization(resquestDTO.getKeyname(),userID));
					} else {	
						List<Object[]> users = userDao.getUserSortByRatingAndBySpecialization(resquestDTO.getKeyname(),resquestDTO.getSortByRating(),
								startFirstResult, startMaxResult,userID);
						response = getUserFilterTransformInDTO(users);
						response.setTotalPage(userDao.getCountUserSortByRatingAndBySpecialization(resquestDTO.getKeyname(),resquestDTO.getSortByRating(),userID));
					}
					response.setCurrentPage(resquestDTO.getPageNo());
					response.setStatus(Constants.SUCCESS_STATUS);
					response.setStatusCode(Constants.SUCCESS_STATUS_CODE);

				} else if (resquestDTO.getFilterParamter().equalsIgnoreCase(Constants.Nationality) //By Nationality and Nationality with rating val
						&& resquestDTO.getFilterParamter() != null) { // Nationality

					if ( resquestDTO.getSortByRating()==null) {
						List<Object[]> users = userDao.getUserByNationalityList(resquestDTO.getKeyname(), "0",
								startFirstResult, startMaxResult,userID);
						        response = getUserFilterTransformInDTO(users);
						        response.setTotalPage(userDao.getCountUserByNationality(resquestDTO.getKeyname(),userID));
					} else {
						List<Object[]> users = userDao.getUserSortByRatingAndNationality(resquestDTO.getSortByRating(),resquestDTO.getKeyname(),
								startFirstResult, startMaxResult,userID);
                                response=getUserFilterTransformInDTO(users);
                                response.setTotalPage(userDao.getCountUserSortByRatingAndNationality(resquestDTO.getSortByRating(),resquestDTO.getKeyname(),userID));
                    }*/
			response.setCurrentPage(resquestDTO.getPageNo());
			response.setStatus(Constants.SUCCESS_STATUS);
			response.setStatusCode(Constants.SUCCESS_STATUS_CODE);

			//	}


			/*******************************************
			 * Get Rating
			 ***************************************************************/
			if((resquestDTO.getNationalityData()==null || 
					resquestDTO.getSpecializationData()==null||
					resquestDTO.getPersonalityData()==null||
					resquestDTO.getDegreeData()==null) && resquestDTO.getSortByRating()!=null) {
				if ((resquestDTO.getSortByRating().equalsIgnoreCase("5") || resquestDTO.getSortByRating().equalsIgnoreCase("6")) &&  resquestDTO.getKeyname()==null) {
					List<Object[]> users = userDao.getUserBySortByRating(resquestDTO.getSortByRating(), startFirstResult,
							startMaxResult,userID);
					response = getUserFilterTransformInDTO(users);
					response.setTotalPage(userDao.getUserBySortByRatingCount(resquestDTO.getSortByRating(),userID));
				}
			}
			

		} catch (Exception e) {
			response.setStatus(Constants.FAILURE_STATUS);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			response.setErrorMsg("User data cannot be fetched as " + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	public ResponseDTO getUserFilterTransformInDTO(List<Object[]> obj) {
		DecimalFormat f = new DecimalFormat("##.##");
		UserDTO userDTO = new UserDTO();
		ResponseDTO response = new ResponseDTO();
		List<Object> responseList = new ArrayList<>();
		for (Object[] user : obj) {
			userDTO = (UserDTO) mapper.convert((User) user[2], userDTO, UserDTO.class);
			userDTO.setStringDateOfBirth(AppUtil.getDateFormat("" + userDTO.getDateOfBirth()));
			userDTO.setStringModifiedOn(AppUtil.getDateFormat("" + userDTO.getModifiedOn()));
			userDTO.setStringModifiedOn(AppUtil.getDateFormat("" + userDTO.getCreatedOn()));

			Set<ProfileImageDTO> profileImageDTOs = userDTO.getProfileImages();
			for (ProfileImageDTO p : profileImageDTOs) {
				p.setImageUrl(PropertyLoader.iSelf.IMAGE_PATH + "" + p.getImageUrl());
				p.setHiddenImageUrl(PropertyLoader.iSelf.IMAGE_PATH + "" + p.getHiddenImageUrl());

			}
			userDTO.setUserLogin(null);
			userDTO.setUserCarts1(null);
			userDTO.setUserPurchasedCartDTO(null);
			userDTO.setUserQuestionAnswers(null);
			userDTO.setProfileImages(profileImageDTOs);
			userDTO.setAge(getAge(userDTO.getDateOfBirth()));
			if (user[0] != null) {
				userDTO.setScore(Double.parseDouble(f.format((Double) user[0])));

			}
			if ((user[1]) != null) {
				userDTO.setReview(Integer.valueOf(user[1].toString()));
			}
			/**If user average rating is not provided**/

			if(userDTO.getUserAvgRatings().size()==0) {
				Set<UserAvgRatingDTO> userAvgRatings=new HashSet<UserAvgRatingDTO>();
				UserAvgRatingDTO userAvgRating=null;
				RatingTypeDTO ratingTypeDTO=null;

				List<RatingType>  ratingTypes=userDao.fetchRatingType();
				for(RatingType ratingType:ratingTypes) {
					userAvgRating=new UserAvgRatingDTO();
					ratingTypeDTO=new RatingTypeDTO();
					if(ratingType.getRatingTypeId()!=9) {
						ratingTypeDTO.setRatingName(ratingType.getRatingName());
						ratingTypeDTO.setRatingValue(ratingType.getRatingValue());
						ratingTypeDTO.setRatingTypeId(ratingType.getRatingTypeId());
						userAvgRating.setRatingType(ratingTypeDTO);
						userAvgRating.setAvgRatingValue(0);
						userAvgRatings.add(userAvgRating);
					}
				}


				userDTO.setUserAvgRatings(userAvgRatings);
			}

			Set<String> userComments=new HashSet<String>();
			Set<UserRatingDTO>  ratingTypes=userDTO.getUserRatings();

			for(UserRatingDTO ratingType:ratingTypes) {

				if(ratingTypes.size()>0 && ratingType.getRatingType().getRatingTypeId()==9) {
					userComments.add(ratingType.getRemarks());
				}
				userDTO.setComments(userComments);
			}

			if(ratingTypes.size()==0) {
				userComments.add("No Comments");
				userDTO.setComments(userComments);
			}
			List<UserAvgRatingDTO> list = new ArrayList<UserAvgRatingDTO>(userDTO.getUserAvgRatings());

			Collections.sort(list, new Comparator<UserAvgRatingDTO>(){

				@Override
				public int compare(UserAvgRatingDTO arg0, UserAvgRatingDTO arg1) {
					return arg0.getRatingType().getRatingTypeId()-arg1.getRatingType().getRatingTypeId();
				}
			});
			Set<UserAvgRatingDTO> userAvgRatings = new LinkedHashSet<UserAvgRatingDTO>(list);
			userDTO.setUserAvgRatings(userAvgRatings);
			/*********************************************/
			responseList.add(userDTO);

		}
		response.setResponseList(responseList);
		response.setStatus(Constants.SUCCESS_STATUS);
		response.setStatusCode(Constants.SUCCESS_STATUS_CODE);
		return response;

	}

	/*public ResponseDTO getUserProfile(int userId) {

		List<Object[]> user = userDao.getUserProfileActiveUser(userId);
		List<Object> users = new ArrayList<Object>();
		users.add(user[2]);

		Iterator itr = users.iterator();
		UserDTO userDTO = null;
		List<Object> responseList = new ArrayList<>();
		ResponseDTO response = new ResponseDTO();
		try {
			while (itr.hasNext()) {
				User useritr = (User) itr.next();
				userDTO = (UserDTO) mapper.convert(useritr, userDTO, UserDTO.class);

				Set<ProfileImageDTO> profileImageDTOs = userDTO.getProfileImages();
				for (ProfileImageDTO p : profileImageDTOs) {
					p.setImageUrl(PropertyLoader.iSelf.IMAGE_PATH + "" + p.getImageUrl());
					p.setHiddenImageUrl(PropertyLoader.iSelf.IMAGE_PATH + "" + p.getHiddenImageUrl());

					System.out.println(p.getHiddenImageUrl());
				}

				userDTO.setProfileImages(profileImageDTOs);
				userDTO.setAge(getAge(userDTO.getDateOfBirth()));
				userDTO.setUserCarts1(null);
				userDTO.setUserPurchasedCartDTO(null);
				userDTO.setUserQuestionAnswers(null);
				userDTO.setUserCarts1(null);
				userDTO.setUserPurchasedCartDTO(null);
				userDTO.setStringDateOfBirth(AppUtil.getDateInString(userDTO.getDateOfBirth()));
				userDTO.setRatingLink(PropertyLoader.getInstance().PROJECT_LINK+Constants.peerRatingSharingLink);
				responseList.add(userDTO);
			}
			response.setResponseList(responseList);
			response.setStatus(Constants.SUCCESS_STATUS);
			response.setStatusCode(Constants.SUCCESS_STATUS_CODE);
			response.setMessage("User details");
			response.setCartCount(String.valueOf(userCartDAO.getCartCountByuserId(userId)));
		} catch (Exception e) {
			response.setStatus(Constants.FAILURE_STATUS);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			response.setErrorMsg("User data cannot be fetched " + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}*/
	public ResponseDTO getUserProfile(int userId) {
		DecimalFormat f = new DecimalFormat("##.##");

		List<Object[]> user = userDao.getUserProfileActiveUser(userId);
		double score = 0;
		int reviews=0;
		Object userVal = null;

		UserDTO userDTO = null;
		List<Object> responseList = new ArrayList<>();
		ResponseDTO response = new ResponseDTO();
		try {

			for(Object[] u:user) {
				if(u[0]==null) {
					score=0;

					reviews=0;

					userVal=u[2];
				}else {
					score=Double.parseDouble(f.format((double) u[0]));

					reviews=(int) u[1];

					userVal=u[2];
				}

			}


			Object useritr = userVal;
			userDTO = (UserDTO) mapper.convert(useritr, userDTO, UserDTO.class);

			Set<ProfileImageDTO> profileImageDTOs = userDTO.getProfileImages();
			for (ProfileImageDTO p : profileImageDTOs) {
				p.setImageUrl(PropertyLoader.iSelf.IMAGE_PATH + "" + p.getImageUrl());
				p.setHiddenImageUrl(PropertyLoader.iSelf.IMAGE_PATH + "" + p.getHiddenImageUrl());

				System.out.println(p.getHiddenImageUrl());
			}

			userDTO.setProfileImages(profileImageDTOs);
			userDTO.setAge(getAge(userDTO.getDateOfBirth()));
			userDTO.setUserCarts1(null);
			userDTO.setUserPurchasedCartDTO(null);
			userDTO.setUserQuestionAnswers(null);
			userDTO.setUserCarts1(null);
			userDTO.setUserPurchasedCartDTO(null);
			userDTO.setStringDateOfBirth(AppUtil.getDateInString(userDTO.getDateOfBirth()));
			userDTO.setRatingLink(PropertyLoader.getInstance().PROJECT_LINK+Constants.peerRatingSharingLink);
			userDTO.setScore(score);
			userDTO.setReview(reviews);



			if(userDTO.getUserAvgRatings().size()==0) {
				Set<UserAvgRatingDTO> userAvgRatings=new HashSet<UserAvgRatingDTO>();
				UserAvgRatingDTO userAvgRating;
				RatingTypeDTO ratingTypeDTO;

				List<RatingType>  ratingTypes=userDao.fetchRatingType();
				for(RatingType ratingType:ratingTypes) {
					userAvgRating=new UserAvgRatingDTO();
					ratingTypeDTO=new RatingTypeDTO();
					if(ratingType.getRatingTypeId()!=9) {
						ratingTypeDTO.setRatingName(ratingType.getRatingName());
						ratingTypeDTO.setRatingValue(ratingType.getRatingValue());
						ratingTypeDTO.setRatingTypeId(ratingType.getRatingTypeId());
						userAvgRating.setRatingType(ratingTypeDTO);
						userAvgRating.setAvgRatingValue(0);
						userAvgRatings.add(userAvgRating);
					}
				}


				userDTO.setUserAvgRatings(userAvgRatings);
			}



			List<UserAvgRatingDTO> list = new ArrayList<UserAvgRatingDTO>(userDTO.getUserAvgRatings());

			Collections.sort(list, new Comparator<UserAvgRatingDTO>(){

				@Override
				public int compare(UserAvgRatingDTO arg0, UserAvgRatingDTO arg1) {
					return arg0.getRatingType().getRatingTypeId()-arg1.getRatingType().getRatingTypeId();
				}
			});

			Set<UserAvgRatingDTO> userAvgRatings = new LinkedHashSet<UserAvgRatingDTO>(list);
			userDTO.setUserAvgRatings(userAvgRatings);

			Set<String> userComments=new HashSet<String>();
			Set<UserRatingDTO>  ratingTypes=userDTO.getUserRatings();

			for(UserRatingDTO ratingType:ratingTypes) {

				if(ratingTypes.size()>0 && ratingType.getRatingType().getRatingTypeId()==9) {
					userComments.add(ratingType.getRemarks());
				}
				userDTO.setComments(userComments);
			}
			responseList.add(userDTO);

			if(ratingTypes.size()==0) {
				userComments.add("No Comments");
				userDTO.setComments(userComments);
			}
			response.setResponseList(responseList);
			response.setStatus(Constants.SUCCESS_STATUS);
			response.setStatusCode(Constants.SUCCESS_STATUS_CODE);
			response.setMessage("User details");
			response.setCartCount(String.valueOf(userCartDAO.getCartCountByuserId(userId)));
		} catch (Exception e) {
			response.setStatus(Constants.FAILURE_STATUS);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			response.setErrorMsg("User data cannot be fetched " + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public ResponseDTO updateCustomer(UserDTO userDTO, HttpServletRequest request) {
		User user = null;
		ResponseDTO response = new ResponseDTO();

		try {
			if (userDTO.getUserId() == 0) {
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				CustomUser customUser = (CustomUser) auth.getPrincipal();
				userDTO.setUserId(customUser.getUserId());
			}

			user = (User) mapper.convert(userDTO, user, User.class);
			userDao.updateCustomer(user);
			if (userDTO.getImageInBytes() != null)
				updateRegisterImage(userDTO, request);
			response.setStatus(Constants.SUCCESS_STATUS);
			response.setStatusCode(Constants.SUCCESS_STATUS_CODE);
			response.setMessage("Profile updated successfully ");

		} catch (Exception e) {
			response.setStatus(Constants.FAILURE_STATUS);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			response.setErrorMsg("User data cannot be updated as " + e.getMessage());
			e.printStackTrace();
		}
		return response;

	}

	@Override
	public boolean updateRegisterImage(UserDTO userDTO, HttpServletRequest request) {
		try {

			User user = userDetailsDao.fetchUserById(userDTO.getUserId());
			int profileId = 0;

			Set<ProfileImage> profileImages = user.getProfileImages();
			for (ProfileImage p : profileImages) {
				profileId = p.getProfileImageId();
			}
			saveRegisterImageDb(userDTO.getImageInBytes(), user.getUserId(), profileId, request);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.infodart.peerhuntr.jpa.service.Impl.UserService#getSuggetionList(java.
	 * lang.String, java.lang.String)
	 * 
	 * For Search
	 */
	@Override
	public ResponseDTO getSuggetionList(String filterParamter, String keyname) {
		// TODO Auto-generated method stub

		ResponseDTO responseDTO = new ResponseDTO();
		List<Object> responseList = new ArrayList<>();
		try {

			if (filterParamter.equalsIgnoreCase(Constants.Nationality)) {
				List<NationalityMaster> nationalityMasters = userDao.getNationalitySuggetionList(keyname);
				System.out.println("nationalityMasters size=====" + nationalityMasters.size());
				NationalityMasterDTO nationalityMasterDTO = null;
				for (NationalityMaster nationalityMaster : nationalityMasters) {

					nationalityMasterDTO = ((NationalityMasterDTO) mapper.convert(nationalityMaster,
							nationalityMasterDTO, NationalityMasterDTO.class));
					responseList.add(nationalityMasterDTO);
				}

				responseDTO.setResponseList(responseList);
			} else if (filterParamter.equalsIgnoreCase(Constants.specialization)) {

				List<SpecializationMaster> nationalityMasters = userDao.getSpecializationSuggetionList(keyname);
				System.out.println("SpecializationMaster=====" + nationalityMasters.size());

				SpecializationMasterDTO specializationMasterDTO = null;
				for (SpecializationMaster specializationMaster : nationalityMasters) {

					specializationMasterDTO = ((SpecializationMasterDTO) mapper.convert(specializationMaster,
							specializationMasterDTO, SpecializationMasterDTO.class));
					specializationMasterDTO.setDegreeMaster(null);
					responseList.add(specializationMasterDTO);
				}

				responseDTO.setResponseList(responseList);

			} else if (filterParamter.equalsIgnoreCase(Constants.degree)) {
				List<DegreeMaster> degreeMasters = userDao.getDegreeSuggetionList(keyname);
				DegreeMasterDTO degreeMasterDTO = null;
				for (DegreeMaster degreeMaster : degreeMasters) {

					degreeMasterDTO = ((DegreeMasterDTO) mapper.convert(degreeMaster, degreeMasterDTO,
							DegreeMasterDTO.class));

					responseList.add(degreeMasterDTO);
				}
				responseDTO.setResponseList(responseList);

			} else if (filterParamter.equalsIgnoreCase(Constants.personalityType)) {
				List<PersonalityMaster> personalityMasters = userDao.getPersonalityMasterSuggetionList(keyname);
				PersonalityMasterDTO personalityMasterDTO = null;
				for (PersonalityMaster personalityMaster : personalityMasters) {
					personalityMasterDTO=((PersonalityMasterDTO)mapper.convert(personalityMaster,personalityMasterDTO,PersonalityMasterDTO.class));
					responseList.add(personalityMasterDTO);
				}
				responseDTO.setResponseList(responseList);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return responseDTO;
	}

	public List<Object> getMultiFilterKeyOnNationalty(SpecializationMasterDTO specializationMaster) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getgetMultiFilterKeyOnNationalty(SpecializationMasterDTO specializationMaster) {
		// TODO Auto-generated method stub
		return null;
	}

}
