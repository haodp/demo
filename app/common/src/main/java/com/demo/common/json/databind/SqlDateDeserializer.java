package com.demo.common.json.databind;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.demo.common.util.StringUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SqlDateDeserializer extends JsonDeserializer<Date> {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctx)
			throws IOException, JsonProcessingException {
		JsonToken currentToken = jp.getCurrentToken();
		if (currentToken == JsonToken.VALUE_STRING) {
			String value =jp.getText().trim();
			if (StringUtil.isEmpty(value)) {
				return null;
			}
			try {
				return new Date(sdf.parse(value).getTime());
			} catch (ParseException e) {
				return null;
			}
		}
		return null;
	}

	@Override
	public Class<Date> handledType() {
		return Date.class;
	}

}