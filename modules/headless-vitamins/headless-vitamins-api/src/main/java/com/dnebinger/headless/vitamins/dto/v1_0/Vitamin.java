package com.dnebinger.headless.vitamins.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dave Nebinger
 * @generated
 */
@Generated("")
@GraphQLName("Vitamin")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Vitamin")
public class Vitamin {

	@GraphQLName("Type")
	public static enum Type {

		VITAMIN("Vitamin"), MINERAL("Mineral"), OTHER("Other");

		@JsonCreator
		public static Type create(String value) {
			for (Type type : values()) {
				if (Objects.equals(type.getValue(), value)) {
					return type;
				}
			}

			return null;
		}

		@JsonValue
		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Type(String value) {
			_value = value;
		}

		private final String _value;

	}

	@Schema(
		description = "A journal articleId if there is a web content article for this vitamin."
	)
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	@JsonIgnore
	public void setArticleId(
		UnsafeSupplier<String, Exception> articleIdUnsafeSupplier) {

		try {
			articleId = articleIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String articleId;

	@Schema(
		description = "Health properties attributed to the vitamin or mineral."
	)
	public String[] getAttributes() {
		return attributes;
	}

	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}

	@JsonIgnore
	public void setAttributes(
		UnsafeSupplier<String[], Exception> attributesUnsafeSupplier) {

		try {
			attributes = attributesUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] attributes;

	@Schema(
		description = "The chemical names of the vitamin or mineral if it has some."
	)
	public String[] getChemicalNames() {
		return chemicalNames;
	}

	public void setChemicalNames(String[] chemicalNames) {
		this.chemicalNames = chemicalNames;
	}

	@JsonIgnore
	public void setChemicalNames(
		UnsafeSupplier<String[], Exception> chemicalNamesUnsafeSupplier) {

		try {
			chemicalNames = chemicalNamesUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] chemicalNames;

	@Schema
	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	@JsonIgnore
	public void setCreator(
		UnsafeSupplier<Creator, Exception> creatorUnsafeSupplier) {

		try {
			creator = creatorUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Creator creator;

	@Schema(description = "The description of the vitamin or mineral.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String description;

	@Schema(description = "The group the vitamin or mineral belongs to.")
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@JsonIgnore
	public void setGroup(
		UnsafeSupplier<String, Exception> groupUnsafeSupplier) {

		try {
			group = groupUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String group;

	@Schema(description = "The vitamin or mineral internal ID.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<String, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String id;

	@Schema(description = "The vitamin or mineral name.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String name;

	@Schema(
		description = "The chemical properties of the vitamin or mineral if it has some."
	)
	public String[] getProperties() {
		return properties;
	}

	public void setProperties(String[] properties) {
		this.properties = properties;
	}

	@JsonIgnore
	public void setProperties(
		UnsafeSupplier<String[], Exception> propertiesUnsafeSupplier) {

		try {
			properties = propertiesUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] properties;

	@Schema(description = "Risks associated with the vitamin or mineral.")
	public String[] getRisks() {
		return risks;
	}

	public void setRisks(String[] risks) {
		this.risks = risks;
	}

	@JsonIgnore
	public void setRisks(
		UnsafeSupplier<String[], Exception> risksUnsafeSupplier) {

		try {
			risks = risksUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] risks;

	@Schema(
		description = "Symptoms associated with the vitamin or mineral deficiency."
	)
	public String[] getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String[] symptoms) {
		this.symptoms = symptoms;
	}

	@JsonIgnore
	public void setSymptoms(
		UnsafeSupplier<String[], Exception> symptomsUnsafeSupplier) {

		try {
			symptoms = symptomsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] symptoms;

	@Schema(description = "The type of the vitamin or mineral.")
	public Type getType() {
		return type;
	}

	@JsonIgnore
	public String getTypeAsString() {
		if (type == null) {
			return null;
		}

		return type.toString();
	}

	public void setType(Type type) {
		this.type = type;
	}

	@JsonIgnore
	public void setType(UnsafeSupplier<Type, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Type type;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Vitamin)) {
			return false;
		}

		Vitamin vitamin = (Vitamin)object;

		return Objects.equals(toString(), vitamin.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (articleId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"articleId\": ");

			sb.append("\"");

			sb.append(_escape(articleId));

			sb.append("\"");
		}

		if (attributes != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"attributes\": ");

			sb.append("[");

			for (int i = 0; i < attributes.length; i++) {
				sb.append("\"");

				sb.append(_escape(attributes[i]));

				sb.append("\"");

				if ((i + 1) < attributes.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (chemicalNames != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chemicalNames\": ");

			sb.append("[");

			for (int i = 0; i < chemicalNames.length; i++) {
				sb.append("\"");

				sb.append(_escape(chemicalNames[i]));

				sb.append("\"");

				if ((i + 1) < chemicalNames.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (creator != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creator\": ");

			sb.append(String.valueOf(creator));
		}

		if (description != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(description));

			sb.append("\"");
		}

		if (group != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"group\": ");

			sb.append("\"");

			sb.append(_escape(group));

			sb.append("\"");
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append("\"");

			sb.append(_escape(id));

			sb.append("\"");
		}

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		if (properties != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"properties\": ");

			sb.append("[");

			for (int i = 0; i < properties.length; i++) {
				sb.append("\"");

				sb.append(_escape(properties[i]));

				sb.append("\"");

				if ((i + 1) < properties.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (risks != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"risks\": ");

			sb.append("[");

			for (int i = 0; i < risks.length; i++) {
				sb.append("\"");

				sb.append(_escape(risks[i]));

				sb.append("\"");

				if ((i + 1) < risks.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (symptoms != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"symptoms\": ");

			sb.append("[");

			for (int i = 0; i < symptoms.length; i++) {
				sb.append("\"");

				sb.append(_escape(symptoms[i]));

				sb.append("\"");

				if ((i + 1) < symptoms.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (type != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(type);

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
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

}