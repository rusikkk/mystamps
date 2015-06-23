/*
 * Copyright (C) 2009-2015 Slava Semushin <slava.semushin@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package ru.mystamps.web.model;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

import ru.mystamps.web.service.dto.AddImageDto;
import ru.mystamps.web.validation.jsr303.NotEmptyFile;
import ru.mystamps.web.validation.jsr303.NotEmptyFilename;

@Getter
@Setter
public class AddImageForm implements AddImageDto {
	
	@NotNull
	@NotEmptyFilename(groups = Image1Checks.class)
	@NotEmptyFile(groups = Image2Checks.class)
	private MultipartFile image;
	
	@GroupSequence({
		Image1Checks.class,
		Image2Checks.class
	})
	public interface ImageChecks {
	}
	
	public interface Image1Checks {
	}
	
	public interface Image2Checks {
	}
	
}
