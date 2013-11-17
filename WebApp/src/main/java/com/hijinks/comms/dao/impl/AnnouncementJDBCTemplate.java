package com.hijinks.comms.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hijinks.comms.dao.AnnouncementDAO;
import com.hijinks.comms.mappers.AnnouncementMapper;
import com.hijinks.comms.models.Announcement;

public class AnnouncementJDBCTemplate implements AnnouncementDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void makeAnnouncement(String title, String text, int communityId,
			int createdBy) {
		String query = "INSERT INTO `Announcement` "
				+ "(`title`, `text`, `communityId`, `createdBy`) "
				+ "VALUES (?, ?, ?, ?)";
		jdbcTemplateObject.update(query, title, text, communityId, createdBy);
	}

	@Override
	public List<Announcement> getAnnouncements(int communityId) {
		String query = "SELECT `Announcement`.`id` as `announcementId` , "
				+ "`title`,"
				+ "`text`,"
				+ "`date`,"
				+ "`Community`.`id` AS `communityId`,"
				+ "`Community`.`name`,"
				+ "`Community`.`keywords`,"
				+ "`Community`.`description`,"
				+ "`Community`.`keywordsEnabled`,"
				+ "`Community`.`visibilityLevel`,"
				+ "`Community`.`accessLevel`,"
				+ "`Community`.`created`,"
				+ "`communityOwner`.`id` AS `communityOwnerId`,"
				+ "`communityOwner`.`fname` AS `communityOwnerFname`,"
				+ "`communityOwner`.`lname` AS `communityOwnerLname`,"
				+ "`communityOwner`.`email` AS `communityOwnerEmail`,"
				+ "`communityOwner`.`type` AS `communityOwnerType`,"
				+ "`user`.`id` AS `userId`,"
				+ "`user`.`fname` AS `userFname`,"
				+ "`user`.`lname` AS `userLname`,"
				+ "`user`.`email` AS `userEmail`,"
				+ "`user`.`type` AS `userType` "
				+ "FROM `Announcement` "
				+ "INNER JOIN `Community` ON "
				+ "`Announcement`.`communityId` = `Community`.`id` "
				+ "INNER JOIN `Users` AS `communityOwner` ON "
				+ "`Community`.`owner` = `communityOwner`.`id` "
				+ "INNER JOIN `Users`AS `user` ON "
				+ "`Announcement`.`createdBy` = `user`.`id` "
				+ "WHERE `Announcement`.`communityId` = ?";
		List<Announcement> requests = jdbcTemplateObject.query(
			query,
			new Object[]{ communityId },
			new AnnouncementMapper()
		);
		return requests;
	}

}
