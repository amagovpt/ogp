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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link bd.ama.service.http.emailContactServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see bd.ama.service.http.emailContactServiceSoap
 * @generated
 */
@ProviderType
public class emailContactSoap implements Serializable {
	public static emailContactSoap toSoapModel(emailContact model) {
		emailContactSoap soapModel = new emailContactSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setNome(model.getNome());
		soapModel.setEmail(model.getEmail());
		soapModel.setMensagem(model.getMensagem());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static emailContactSoap[] toSoapModels(emailContact[] models) {
		emailContactSoap[] soapModels = new emailContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static emailContactSoap[][] toSoapModels(emailContact[][] models) {
		emailContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new emailContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new emailContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static emailContactSoap[] toSoapModels(List<emailContact> models) {
		List<emailContactSoap> soapModels = new ArrayList<emailContactSoap>(models.size());

		for (emailContact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new emailContactSoap[soapModels.size()]);
	}

	public emailContactSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getMensagem() {
		return _mensagem;
	}

	public void setMensagem(String mensagem) {
		_mensagem = mensagem;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	private String _uuid;
	private long _id;
	private String _nome;
	private String _email;
	private String _mensagem;
	private boolean _status;
}