package com.ssafy.weather;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherSaxParser extends DefaultHandler {
	private StringBuilder sb;
	WeatherDto weatherDto;
	List<WeatherDto> list;

	private static WeatherSaxParser parser = new WeatherSaxParser();

	private WeatherSaxParser() {
	}

	public static WeatherSaxParser getParser() {
		return parser;
	}

	public List<WeatherDto> getNewsList(String url) {
		if(list != null)
			list.removeAll(list);
		connectWeather(url);
		return list;
	}

	private List<WeatherDto> connectWeather(String url) {
		SAXParserFactory f = SAXParserFactory.newInstance();
		try {
			SAXParser parser = f.newSAXParser();
//			TODO : url을 이용하여 xml 문서를 parsing
			parser.parse(new URL(url).openStream(), this);
			return list;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
//			TODO: Override 하세요.
		list = new ArrayList<>();
		sb = new StringBuilder();
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
//			TODO: Override 하세요.
		sb.append(ch, start, length);
	}

	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, name, attributes);
//			TODO: Override 하세요.
		if(name.equals("data")) {
			weatherDto = new WeatherDto();
		}
	}

	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
//			TODO: Override 하세요.
		if(weatherDto != null) {
			if(name.equalsIgnoreCase("hour")) {
				weatherDto.setHour(sb.toString().trim());
			} else if(name.equalsIgnoreCase("temp")) {
				weatherDto.setTemp(sb.toString().trim());
			} else if(name.equalsIgnoreCase("wfkor")) {
				weatherDto.setWfKor(sb.toString().trim());
			} else if(name.equalsIgnoreCase("wfen")) {
				weatherDto.setWfEn(sb.toString().trim());
			} else if(name.equalsIgnoreCase("reh")) {
				weatherDto.setReh(sb.toString().trim());
			} else if(name.equalsIgnoreCase("data")) {
				list.add(weatherDto);
			}
		}
		sb.setLength(0);
	}

}