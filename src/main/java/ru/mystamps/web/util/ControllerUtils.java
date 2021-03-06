/*
 * Copyright (C) 2009-2018 Slava Semushin <slava.semushin@gmail.com>
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
package ru.mystamps.web.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.UriComponentsBuilder;

public final class ControllerUtils {

	private ControllerUtils() {
	}

	public static String redirectTo(String url, Object... args) {
		String dstUrl = UriComponentsBuilder.fromUriString(url)
			.buildAndExpand(args)
			.toString();

		return "redirect:" + dstUrl;
	}
	
	public static void printHtml(HttpServletResponse response, String html) throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(html);
	}
	
}
