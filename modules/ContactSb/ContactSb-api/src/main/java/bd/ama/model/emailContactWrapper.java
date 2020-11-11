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

package bd.ama.model;

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
 * This class is a wrapper for {@link emailContact}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see emailContact
 * @generated
 */
@ProviderType
public class emailContactWrapper implements emailContact,
	ModelWrapper<emailContact> {
	public emailContactWrapper(emailContact emailContact) {
		_emailContact = emailContact;
	}

	@Override
	public Class<?> getModelClass() {
		return emailContact.class;
	}

	@Override
	public String getModelClassName() {
		return emailContact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("email", getEmail());
		attributes.put("mensagem", getMensagem());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

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
	public bd.ama.model.emailContact toEscapedModel() {
		return new emailContactWrapper(_emailContact.toEscapedModel());
	}

	@Override
	public bd.ama.model.emailContact toUnescapedModel() {
		return new emailContactWrapper(_emailContact.toUnescapedModel());
	}

	/**
	* Returns the status of this email contact.
	*
	* @return the status of this email contact
	*/
	@Override
	public boolean getStatus() {
		return _emailContact.getStatus();
	}

	@Override
	public boolean isCachedModel() {
		return _emailContact.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _emailContact.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _emailContact.isNew();
	}

	/**
	* Returns <code>true</code> if this email contact is status.
	*
	* @return <code>true</code> if this email contact is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _emailContact.isStatus();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _emailContact.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<bd.ama.model.emailContact> toCacheModel() {
		return _emailContact.toCacheModel();
	}

	@Override
	public int compareTo(bd.ama.model.emailContact emailContact) {
		return _emailContact.compareTo(emailContact);
	}

	@Override
	public int hashCode() {
		return _emailContact.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _emailContact.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new emailContactWrapper((emailContact)_emailContact.clone());
	}

	/**
	* Returns the email of this email contact.
	*
	* @return the email of this email contact
	*/
	@Override
	public java.lang.String getEmail() {
		return _emailContact.getEmail();
	}

	/**
	* Returns the mensagem of this email contact.
	*
	* @return the mensagem of this email contact
	*/
	@Override
	public java.lang.String getMensagem() {
		return _emailContact.getMensagem();
	}

	/**
	* Returns the nome of this email contact.
	*
	* @return the nome of this email contact
	*/
	@Override
	public java.lang.String getNome() {
		return _emailContact.getNome();
	}

	/**
	* Returns the uuid of this email contact.
	*
	* @return the uuid of this email contact
	*/
	@Override
	public java.lang.String getUuid() {
		return _emailContact.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _emailContact.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _emailContact.toXmlString();
	}

	/**
	* Returns the ID of this email contact.
	*
	* @return the ID of this email contact
	*/
	@Override
	public long getId() {
		return _emailContact.getId();
	}

	/**
	* Returns the primary key of this email contact.
	*
	* @return the primary key of this email contact
	*/
	@Override
	public long getPrimaryKey() {
		return _emailContact.getPrimaryKey();
	}

	@Override
	public void persist() {
		_emailContact.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_emailContact.setCachedModel(cachedModel);
	}

	/**
	* Sets the email of this email contact.
	*
	* @param email the email of this email contact
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_emailContact.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_emailContact.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_emailContact.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_emailContact.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this email contact.
	*
	* @param id the ID of this email contact
	*/
	@Override
	public void setId(long id) {
		_emailContact.setId(id);
	}

	/**
	* Sets the mensagem of this email contact.
	*
	* @param mensagem the mensagem of this email contact
	*/
	@Override
	public void setMensagem(java.lang.String mensagem) {
		_emailContact.setMensagem(mensagem);
	}

	@Override
	public void setNew(boolean n) {
		_emailContact.setNew(n);
	}

	/**
	* Sets the nome of this email contact.
	*
	* @param nome the nome of this email contact
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_emailContact.setNome(nome);
	}

	/**
	* Sets the primary key of this email contact.
	*
	* @param primaryKey the primary key of this email contact
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_emailContact.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_emailContact.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this email contact is status.
	*
	* @param status the status of this email contact
	*/
	@Override
	public void setStatus(boolean status) {
		_emailContact.setStatus(status);
	}

	/**
	* Sets the uuid of this email contact.
	*
	* @param uuid the uuid of this email contact
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_emailContact.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof emailContactWrapper)) {
			return false;
		}

		emailContactWrapper emailContactWrapper = (emailContactWrapper)obj;

		if (Objects.equals(_emailContact, emailContactWrapper._emailContact)) {
			return true;
		}

		return false;
	}

	@Override
	public emailContact getWrappedModel() {
		return _emailContact;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _emailContact.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _emailContact.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_emailContact.resetOriginalValues();
	}

	private final emailContact _emailContact;
}