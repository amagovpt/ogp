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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class commentsSoap implements Serializable {
	public static commentsSoap toSoapModel(comments model) {
		commentsSoap soapModel = new commentsSoap();

		soapModel.setId(model.getId());
		soapModel.setNome(model.getNome());
		soapModel.setEmail(model.getEmail());
		soapModel.setMensagem(model.getMensagem());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static commentsSoap[] toSoapModels(comments[] models) {
		commentsSoap[] soapModels = new commentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static commentsSoap[][] toSoapModels(comments[][] models) {
		commentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new commentsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new commentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static commentsSoap[] toSoapModels(List<comments> models) {
		List<commentsSoap> soapModels = new ArrayList<commentsSoap>(models.size());

		for (comments model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new commentsSoap[soapModels.size()]);
	}

	public commentsSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	private long _id;
	private String _nome;
	private String _email;
	private String _mensagem;
	private boolean _status;
}