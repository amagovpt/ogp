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

package AMA.OpenGov.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link comments}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see comments
 * @generated
 */
@ProviderType
public class commentsWrapper implements comments, ModelWrapper<comments> {
	public commentsWrapper(comments comments) {
		_comments = comments;
	}

	@Override
	public Class<?> getModelClass() {
		return comments.class;
	}

	@Override
	public String getModelClassName() {
		return comments.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("email", getEmail());
		attributes.put("mensagem", getMensagem());
		attributes.put("status", getStatus());

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
	}

	@Override
	public AMA.OpenGov.model.comments toEscapedModel() {
		return new commentsWrapper(_comments.toEscapedModel());
	}

	@Override
	public AMA.OpenGov.model.comments toUnescapedModel() {
		return new commentsWrapper(_comments.toUnescapedModel());
	}

	/**
	* Returns the status of this comments.
	*
	* @return the status of this comments
	*/
	@Override
	public boolean getStatus() {
		return _comments.getStatus();
	}

	@Override
	public boolean isCachedModel() {
		return _comments.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _comments.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _comments.isNew();
	}

	/**
	* Returns <code>true</code> if this comments is status.
	*
	* @return <code>true</code> if this comments is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _comments.isStatus();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _comments.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AMA.OpenGov.model.comments> toCacheModel() {
		return _comments.toCacheModel();
	}

	@Override
	public int compareTo(AMA.OpenGov.model.comments comments) {
		return _comments.compareTo(comments);
	}

	@Override
	public int hashCode() {
		return _comments.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _comments.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new commentsWrapper((comments)_comments.clone());
	}

	/**
	* Returns the email of this comments.
	*
	* @return the email of this comments
	*/
	@Override
	public java.lang.String getEmail() {
		return _comments.getEmail();
	}

	/**
	* Returns the mensagem of this comments.
	*
	* @return the mensagem of this comments
	*/
	@Override
	public java.lang.String getMensagem() {
		return _comments.getMensagem();
	}

	/**
	* Returns the nome of this comments.
	*
	* @return the nome of this comments
	*/
	@Override
	public java.lang.String getNome() {
		return _comments.getNome();
	}

	@Override
	public java.lang.String toString() {
		return _comments.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _comments.toXmlString();
	}

	/**
	* Returns the ID of this comments.
	*
	* @return the ID of this comments
	*/
	@Override
	public long getId() {
		return _comments.getId();
	}

	/**
	* Returns the primary key of this comments.
	*
	* @return the primary key of this comments
	*/
	@Override
	public long getPrimaryKey() {
		return _comments.getPrimaryKey();
	}

	@Override
	public void persist() {
		_comments.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_comments.setCachedModel(cachedModel);
	}

	/**
	* Sets the email of this comments.
	*
	* @param email the email of this comments
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_comments.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_comments.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_comments.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_comments.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this comments.
	*
	* @param id the ID of this comments
	*/
	@Override
	public void setId(long id) {
		_comments.setId(id);
	}

	/**
	* Sets the mensagem of this comments.
	*
	* @param mensagem the mensagem of this comments
	*/
	@Override
	public void setMensagem(java.lang.String mensagem) {
		_comments.setMensagem(mensagem);
	}

	@Override
	public void setNew(boolean n) {
		_comments.setNew(n);
	}

	/**
	* Sets the nome of this comments.
	*
	* @param nome the nome of this comments
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_comments.setNome(nome);
	}

	/**
	* Sets the primary key of this comments.
	*
	* @param primaryKey the primary key of this comments
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_comments.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_comments.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this comments is status.
	*
	* @param status the status of this comments
	*/
	@Override
	public void setStatus(boolean status) {
		_comments.setStatus(status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof commentsWrapper)) {
			return false;
		}

		commentsWrapper commentsWrapper = (commentsWrapper)obj;

		if (Objects.equals(_comments, commentsWrapper._comments)) {
			return true;
		}

		return false;
	}

	@Override
	public comments getWrappedModel() {
		return _comments;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _comments.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _comments.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_comments.resetOriginalValues();
	}

	private final comments _comments;
}