/*
 * Copyright (C) 2009-2011 Slava Semushin <slava.semushin@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package ru.mystamps.web.validation;

import ru.mystamps.web.entity.Country;
import ru.mystamps.web.entity.User;
import ru.mystamps.web.entity.UsersActivation;

public final class ValidationRules {
	
	public static final Integer LOGIN_MIN_LENGTH = 2;
	public static final Integer LOGIN_MAX_LENGTH = User.LOGIN_LENGTH;
	public static final String LOGIN_REGEXP = "[-_a-zA-Z0-9]+";
	
	public static final Integer NAME_MAX_LENGTH = User.NAME_LENGTH;
	public static final String NAME_REGEXP1 = "[- \\p{L}]+";
	public static final String NAME_REGEXP2 = "[ \\p{L}]([- \\p{L}]+[ \\p{L}])*";
	
	public static final Integer PASSWORD_MIN_LENGTH = 4;
	public static final String PASSWORD_REGEXP = "[-_a-zA-Z0-9]+";
	
	public static final Integer EMAIL_MAX_LENGTH = UsersActivation.EMAIL_LENGTH;
	
	public static final Integer ACT_KEY_LENGTH = UsersActivation.ACTIVATION_KEY_LENGTH;
	public static final String ACT_KEY_REGEXP = "[0-9a-z]+";
	
	public static final Integer COUNTRY_NAME_MIN_LENGTH = 3;
	public static final Integer COUNTRY_NAME_MAX_LENGTH = Country.NAME_LENGTH;
	public static final String COUNTRY_NAME_REGEXP1 = "[- a-zA-Z]+";
	public static final String COUNTRY_NAME_REGEXP2 = "[ a-zA-Z]([- a-zA-Z]+[ a-zA-Z])*";
	
	private ValidationRules() {
	}
	
}

