package com.dnebinger.headless.vitamins.client.dto.v1_0;

import com.dnebinger.headless.vitamins.client.function.UnsafeSupplier;
import com.dnebinger.headless.vitamins.client.serdes.v1_0.VitaminSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Dave Nebinger
 * @generated
 */
@Generated("")
public class Vitamin {

	public static enum Type {

		VITAMIN("Vitamin"), MINERAL("Mineral"), OTHER("Other");

		public static Type create(String value) {
			for (Type type : values()) {
				if (Objects.equals(type.getValue(), value)) {
					return type;
				}
			}

			return null;
		}

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

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public void setArticleId(
		UnsafeSupplier<String, Exception> articleIdUnsafeSupplier) {

		try {
			articleId = articleIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String articleId;

	public String[] getAttributes() {
		return attributes;
	}

	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}

	public void setAttributes(
		UnsafeSupplier<String[], Exception> attributesUnsafeSupplier) {

		try {
			attributes = attributesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] attributes;

	public String[] getChemicalNames() {
		return chemicalNames;
	}

	public void setChemicalNames(String[] chemicalNames) {
		this.chemicalNames = chemicalNames;
	}

	public void setChemicalNames(
		UnsafeSupplier<String[], Exception> chemicalNamesUnsafeSupplier) {

		try {
			chemicalNames = chemicalNamesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] chemicalNames;

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public void setCreator(
		UnsafeSupplier<Creator, Exception> creatorUnsafeSupplier) {

		try {
			creator = creatorUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Creator creator;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String description;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void setGroup(
		UnsafeSupplier<String, Exception> groupUnsafeSupplier) {

		try {
			group = groupUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String group;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<String, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	public String[] getProperties() {
		return properties;
	}

	public void setProperties(String[] properties) {
		this.properties = properties;
	}

	public void setProperties(
		UnsafeSupplier<String[], Exception> propertiesUnsafeSupplier) {

		try {
			properties = propertiesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] properties;

	public String[] getRisks() {
		return risks;
	}

	public void setRisks(String[] risks) {
		this.risks = risks;
	}

	public void setRisks(
		UnsafeSupplier<String[], Exception> risksUnsafeSupplier) {

		try {
			risks = risksUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] risks;

	public String[] getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String[] symptoms) {
		this.symptoms = symptoms;
	}

	public void setSymptoms(
		UnsafeSupplier<String[], Exception> symptomsUnsafeSupplier) {

		try {
			symptoms = symptomsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] symptoms;

	public Type getType() {
		return type;
	}

	public String getTypeAsString() {
		if (type == null) {
			return null;
		}

		return type.toString();
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setType(UnsafeSupplier<Type, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

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
		return VitaminSerDes.toJSON(this);
	}

}