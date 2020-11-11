/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package AMA.OpenGov.LocalDataSaveEmail.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ogp_comments}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ogp_comments
 * @generated
 */
@ProviderType
public class ogp_commentsWrapper implements ogp_comments,
	ModelWrapper<ogp_comments> {
	public ogp_commentsWrapper(ogp_comments ogp_comments) {
		_ogp_comments = ogp_comments;
	}

	@Override
	public Class<?> getModelClass() {
		return ogp_comments.class;
	}

	@Override
	public String getModelClassName() {
		return ogp_comments.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("email", getEmail());
		attributes.put("mensagem", getMensagem());
		attributes.put("status", getStatus());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String mensagem = (String)attributes.get("mensagem");

		if (mensagem != null) {
			setMensagem(mensagem);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}
	}

	@Override
	public AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments toEscapedModel() {
		return new ogp_commentsWrapper(_ogp_comments.toEscapedModel());
	}

	@Override
	public AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments toUnescapedModel() {
		return new ogp_commentsWrapper(_ogp_comments.toUnescapedModel());
	}

	/**
	* Returns the status of this ogp_comments.
	*
	* @return the status of this ogp_comments
	*/
	@Override
	public boolean getStatus() {
		return _ogp_comments.getStatus();
	}

	@Override
	public boolean isCachedModel() {
		return _ogp_comments.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _ogp_comments.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ogp_comments.isNew();
	}

	/**
	* Returns <code>true</code> if this ogp_comments is status.
	*
	* @return <code>true</code> if this ogp_comments is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _ogp_comments.isStatus();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ogp_comments.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments> toCacheModel() {
		return _ogp_comments.toCacheModel();
	}

	@Override
	public int compareTo(
		AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments ogp_comments) {
		return _ogp_comments.compareTo(ogp_comments);
	}

	@Override
	public int hashCode() {
		return _ogp_comments.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ogp_comments.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ogp_commentsWrapper((ogp_comments)_ogp_comments.clone());
	}

	/**
	* Returns the email of this ogp_comments.
	*
	* @return the email of this ogp_comments
	*/
	@Override
	public java.lang.String getEmail() {
		return _ogp_comments.getEmail();
	}

	/**
	* Returns the mensagem of this ogp_comments.
	*
	* @return the mensagem of this ogp_comments
	*/
	@Override
	public java.lang.String getMensagem() {
		return _ogp_comments.getMensagem();
	}

	/**
	* Returns the nome of this ogp_comments.
	*
	* @return the nome of this ogp_comments
	*/
	@Override
	public java.lang.String getNome() {
		return _ogp_comments.getNome();
	}

	@Override
	public java.lang.String toString() {
		return _ogp_comments.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ogp_comments.toXmlString();
	}

	/**
	* Returns the date of this ogp_comments.
	*
	* @return the date of this ogp_comments
	*/
	@Override
	public Date getDate() {
		return _ogp_comments.getDate();
	}

	/**
	* Returns the ID of this ogp_comments.
	*
	* @return the ID of this ogp_comments
	*/
	@Override
	public long getId() {
		return _ogp_comments.getId();
	}

	/**
	* Returns the primary key of this ogp_comments.
	*
	* @return the primary key of this ogp_comments
	*/
	@Override
	public long getPrimaryKey() {
		return _ogp_comments.getPrimaryKey();
	}

	@Override
	public void persist() {
		_ogp_comments.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ogp_comments.setCachedModel(cachedModel);
	}

	/**
	* Sets the date of this ogp_comments.
	*
	* @param date the date of this ogp_comments
	*/
	@Override
	public void setDate(Date date) {
		_ogp_comments.setDate(date);
	}

	/**
	* Sets the email of this ogp_comments.
	*
	* @param email the email of this ogp_comments
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_ogp_comments.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ogp_comments.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ogp_comments.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ogp_comments.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this ogp_comments.
	*
	* @param id the ID of this ogp_comments
	*/
	@Override
	public void setId(long id) {
		_ogp_comments.setId(id);
	}

	/**
	* Sets the mensagem of this ogp_comments.
	*
	* @param mensagem the mensagem of this ogp_comments
	*/
	@Override
	public void setMensagem(java.lang.String mensagem) {
		_ogp_comments.setMensagem(mensagem);
	}

	@Override
	public void setNew(boolean n) {
		_ogp_comments.setNew(n);
	}

	/**
	* Sets the nome of this ogp_comments.
	*
	* @param nome the nome of this ogp_comments
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_ogp_comments.setNome(nome);
	}

	/**
	* Sets the primary key of this ogp_comments.
	*
	* @param primaryKey the primary key of this ogp_comments
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ogp_comments.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ogp_comments.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this ogp_comments is status.
	*
	* @param status the status of this ogp_comments
	*/
	@Override
	public void setStatus(boolean status) {
		_ogp_comments.setStatus(status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ogp_commentsWrapper)) {
			return false;
		}

		ogp_commentsWrapper ogp_commentsWrapper = (ogp_commentsWrapper)obj;

		if (Objects.equals(_ogp_comments, ogp_commentsWrapper._ogp_comments)) {
			return true;
		}

		return false;
	}

	@Override
	public ogp_comments getWrappedModel() {
		return _ogp_comments;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ogp_comments.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ogp_comments.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ogp_comments.resetOriginalValues();
	}

	private final ogp_comments _ogp_comments;
}