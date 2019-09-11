package com.dnebinger.headless.vitamins.client.serdes.v1_0;

import com.dnebinger.headless.vitamins.client.dto.v1_0.Vitamin;
import com.dnebinger.headless.vitamins.client.json.BaseJSONParser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

/**
 * @author Dave Nebinger
 * @generated
 */
@Generated("")
public class VitaminSerDes {

	public static Vitamin toDTO(String json) {
		VitaminJSONParser vitaminJSONParser = new VitaminJSONParser();

		return vitaminJSONParser.parseToDTO(json);
	}

	public static Vitamin[] toDTOs(String json) {
		VitaminJSONParser vitaminJSONParser = new VitaminJSONParser();

		return vitaminJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Vitamin vitamin) {
		if (vitamin == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (vitamin.getArticleId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"articleId\": ");

			sb.append("\"");

			sb.append(_escape(vitamin.getArticleId()));

			sb.append("\"");
		}

		if (vitamin.getAttributes() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"attributes\": ");

			sb.append("[");

			for (int i = 0; i < vitamin.getAttributes().length; i++) {
				sb.append("\"");

				sb.append(_escape(vitamin.getAttributes()[i]));

				sb.append("\"");

				if ((i + 1) < vitamin.getAttributes().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (vitamin.getChemicalNames() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chemicalNames\": ");

			sb.append("[");

			for (int i = 0; i < vitamin.getChemicalNames().length; i++) {
				sb.append("\"");

				sb.append(_escape(vitamin.getChemicalNames()[i]));

				sb.append("\"");

				if ((i + 1) < vitamin.getChemicalNames().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (vitamin.getCreator() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creator\": ");

			sb.append(String.valueOf(vitamin.getCreator()));
		}

		if (vitamin.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(vitamin.getDescription()));

			sb.append("\"");
		}

		if (vitamin.getGroup() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"group\": ");

			sb.append("\"");

			sb.append(_escape(vitamin.getGroup()));

			sb.append("\"");
		}

		if (vitamin.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append("\"");

			sb.append(_escape(vitamin.getId()));

			sb.append("\"");
		}

		if (vitamin.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(vitamin.getName()));

			sb.append("\"");
		}

		if (vitamin.getProperties() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"properties\": ");

			sb.append("[");

			for (int i = 0; i < vitamin.getProperties().length; i++) {
				sb.append("\"");

				sb.append(_escape(vitamin.getProperties()[i]));

				sb.append("\"");

				if ((i + 1) < vitamin.getProperties().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (vitamin.getRisks() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"risks\": ");

			sb.append("[");

			for (int i = 0; i < vitamin.getRisks().length; i++) {
				sb.append("\"");

				sb.append(_escape(vitamin.getRisks()[i]));

				sb.append("\"");

				if ((i + 1) < vitamin.getRisks().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (vitamin.getSymptoms() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"symptoms\": ");

			sb.append("[");

			for (int i = 0; i < vitamin.getSymptoms().length; i++) {
				sb.append("\"");

				sb.append(_escape(vitamin.getSymptoms()[i]));

				sb.append("\"");

				if ((i + 1) < vitamin.getSymptoms().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (vitamin.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(vitamin.getType());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		VitaminJSONParser vitaminJSONParser = new VitaminJSONParser();

		return vitaminJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Vitamin vitamin) {
		if (vitamin == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (vitamin.getArticleId() == null) {
			map.put("articleId", null);
		}
		else {
			map.put("articleId", String.valueOf(vitamin.getArticleId()));
		}

		if (vitamin.getAttributes() == null) {
			map.put("attributes", null);
		}
		else {
			map.put("attributes", String.valueOf(vitamin.getAttributes()));
		}

		if (vitamin.getChemicalNames() == null) {
			map.put("chemicalNames", null);
		}
		else {
			map.put(
				"chemicalNames", String.valueOf(vitamin.getChemicalNames()));
		}

		if (vitamin.getCreator() == null) {
			map.put("creator", null);
		}
		else {
			map.put("creator", String.valueOf(vitamin.getCreator()));
		}

		if (vitamin.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(vitamin.getDescription()));
		}

		if (vitamin.getGroup() == null) {
			map.put("group", null);
		}
		else {
			map.put("group", String.valueOf(vitamin.getGroup()));
		}

		if (vitamin.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(vitamin.getId()));
		}

		if (vitamin.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(vitamin.getName()));
		}

		if (vitamin.getProperties() == null) {
			map.put("properties", null);
		}
		else {
			map.put("properties", String.valueOf(vitamin.getProperties()));
		}

		if (vitamin.getRisks() == null) {
			map.put("risks", null);
		}
		else {
			map.put("risks", String.valueOf(vitamin.getRisks()));
		}

		if (vitamin.getSymptoms() == null) {
			map.put("symptoms", null);
		}
		else {
			map.put("symptoms", String.valueOf(vitamin.getSymptoms()));
		}

		if (vitamin.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(vitamin.getType()));
		}

		return map;
	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static class VitaminJSONParser extends BaseJSONParser<Vitamin> {

		@Override
		protected Vitamin createDTO() {
			return new Vitamin();
		}

		@Override
		protected Vitamin[] createDTOArray(int size) {
			return new Vitamin[size];
		}

		@Override
		protected void setField(
			Vitamin vitamin, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "articleId")) {
				if (jsonParserFieldValue != null) {
					vitamin.setArticleId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "attributes")) {
				if (jsonParserFieldValue != null) {
					vitamin.setAttributes(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "chemicalNames")) {
				if (jsonParserFieldValue != null) {
					vitamin.setChemicalNames(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "creator")) {
				if (jsonParserFieldValue != null) {
					vitamin.setCreator(
						CreatorSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					vitamin.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "group")) {
				if (jsonParserFieldValue != null) {
					vitamin.setGroup((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					vitamin.setId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					vitamin.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "properties")) {
				if (jsonParserFieldValue != null) {
					vitamin.setProperties(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "risks")) {
				if (jsonParserFieldValue != null) {
					vitamin.setRisks(toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "symptoms")) {
				if (jsonParserFieldValue != null) {
					vitamin.setSymptoms(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					vitamin.setType(
						Vitamin.Type.create((String)jsonParserFieldValue));
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}