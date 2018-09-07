package com.infodart.peerhuntr.jpa.service.Impl;

import com.infodart.peerhuntr.dto.peerRating.UserRatingDTO;
import com.infodart.peerhuntr.dto.response.ResponseDTO;

public interface RatingService {

	public ResponseDTO submitRating(UserRatingDTO userRatingDTO);
}
