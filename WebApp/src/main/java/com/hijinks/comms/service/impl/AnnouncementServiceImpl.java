package com.hijinks.comms.service.impl;

import java.util.List;
import com.hijinks.comms.dao.AnnouncementDAO;
import com.hijinks.comms.models.Announcement;
import com.hijinks.comms.service.AnnouncementService;

public class AnnouncementServiceImpl implements AnnouncementService {
	private AnnouncementDAO announcementDAO;
	public void setAnnouncementDAO(AnnouncementDAO announcementDAO) {
		this.announcementDAO = announcementDAO;
	}

	@Override
	public void makeAnnouncement(final String title, final String text,
		final int communityId, final int createdBy
	) {
		announcementDAO.makeAnnouncement(
			title,
			text,
			communityId,
			createdBy
		);
	}

	@Override
	public List<Announcement> getAnnouncements(int communityId) {
		return announcementDAO.getAnnouncements(communityId);
	}

}
