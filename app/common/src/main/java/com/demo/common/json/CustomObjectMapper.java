package com.demo.common.json;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.demo.common.json.databind.DateDeserializer;
import com.demo.common.json.databind.DateSerializer;
import com.demo.common.json.databind.NullValueSerializer;
import com.demo.common.json.databind.SqlDateDeserializer;
import com.demo.common.json.databind.SqlDateSerializer;
import com.demo.common.json.databind.TimestampDeserializer;
import com.demo.common.json.databind.TimestampSerializer;

public class CustomObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;

	/** LOG */
	protected static Logger log = LoggerFactory.getLogger(CustomObjectMapper.class);

	public void initialize() {

		// Null值序列化
		this.getSerializerProvider().setNullValueSerializer(new NullValueSerializer());

		// Date类型序列化、反序列化
		Module dateModule = new SimpleModule("DateModule", this.version())
				.addSerializer(Date.class, new DateSerializer())
				.addDeserializer(Date.class, new DateDeserializer())
				.addSerializer(java.sql.Date.class, new SqlDateSerializer())
				.addDeserializer(java.sql.Date.class, new SqlDateDeserializer());

		// Timestamp类型序列化、反序列化
		Module timestampModule = new SimpleModule("TimestampModule", this.version())
				.addSerializer(Timestamp.class, new TimestampSerializer())
				.addDeserializer(Timestamp.class, new TimestampDeserializer());

		this.registerModules(dateModule, timestampModule);

		log.info("Modules regist successfully.");
	}

}
