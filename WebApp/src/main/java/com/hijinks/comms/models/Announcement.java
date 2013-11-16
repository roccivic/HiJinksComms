package com.hijinks.comms.models;

import java.util.Date;

public class Announcement {
	int id;
	String title;
	String text;
	Community community;
	Date date;
	User createdBy;
}
