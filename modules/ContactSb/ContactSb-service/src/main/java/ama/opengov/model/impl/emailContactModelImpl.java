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

package ama.opengov.model.impl;

import aQute.bnd.annotation.ProviderType;

import ama.opengov.model.emailContact;
import ama.opengov.model.emailContactModel;
import ama.opengov.model.emailContactSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the emailContact service. Represents a row in the &quot;email_contact&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link emailContactModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link emailContactImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see emailContactImpl
 * @see emailContact
 * @see emailContactModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class emailContactModelImpl extends BaseModelImpl<emailContact>
	implements emailContactModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a email contact model instance should use the {@link emailContact} interface instead.
	 */
	public static final String TABLE_NAME = "email_contact";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "id_", Types.BIGINT },
			{ "nome", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "mensagem", Types.VARCHAR },
			{ "status", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nome", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mensagem", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table email_contact (uuid_ VARCHAR(75) null,id_ LONG not null primary key,nome VARCHAR(75) null,email VARCHAR(75) null,mensagem VARCHAR(75) null,status BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table email_contact";
	public static final String ORDER_BY_JPQL = " ORDER BY emailContact.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY email_contact.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(bd.ama.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.ama.opengov.model.emailContact"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(bd.ama.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.ama.opengov.model.emailContact"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(bd.ama.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.ama.opengov.model.emailContact"),
			true);
	public static final long NOME_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;
	public static final long ID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static emailContact toModel(emailContactSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		emailContact model = new emailContactImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setNome(soapModel.getNome());
		model.setEmail(soapModel.getEmail());
		model.setMensagem(soapModel.getMensagem());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<emailContact> toModels(emailContactSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<emailContact> models = new ArrayList<emailContact>(soapModels.length);

		for (emailContactSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(bd.ama.service.util.ServiceProps.get(
				"lock.expiration.time.ama.opengov.model.emailContact"));

	public emailContactModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_columnBitmask = -1L;

		_id = id;
	}

	@JSON
	@Override
	public String getNome() {
		if (_nome == null) {
			return StringPool.BLANK;
		}
		else {
			return _nome;
		}
	}

	@Override
	public void setNome(String nome) {
		_columnBitmask |= NOME_COLUMN_BITMASK;

		if (_originalNome == null) {
			_originalNome = _nome;
		}

		_nome = nome;
	}

	public String getOriginalNome() {
		return GetterUtil.getString(_originalNome);
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public String getMensagem() {
		if (_mensagem == null) {
			return StringPool.BLANK;
		}
		else {
			return _mensagem;
		}
	}

	@Override
	public void setMensagem(String mensagem) {
		_mensagem = mensagem;
	}

	@JSON
	@Override
	public boolean getStatus() {
		return _status;
	}

	@JSON
	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			emailContact.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public emailContact toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (emailContact)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		emailContactImpl emailContactImpl = new emailContactImpl();

		emailContactImpl.setUuid(getUuid());
		emailContactImpl.setId(getId());
		emailContactImpl.setNome(getNome());
		emailContactImpl.setEmail(getEmail());
		emailContactImpl.setMensagem(getMensagem());
		emailContactImpl.setStatus(getStatus());

		emailContactImpl.resetOriginalValues();

		return emailContactImpl;
	}

	@Override
	public int compareTo(emailContact emailContact) {
		int value = 0;

		if (getId() < emailContact.getId()) {
			value = -1;
		}
		else if (getId() > emailContact.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof emailContact)) {
			return false;
		}

		emailContact emailContact = (emailContact)obj;

		long primaryKey = emailContact.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		emailContactModelImpl emailContactModelImpl = this;

		emailContactModelImpl._originalUuid = emailContactModelImpl._uuid;

		emailContactModelImpl._originalNome = emailContactModelImpl._nome;

		emailContactModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<emailContact> toCacheModel() {
		emailContactCacheModel emailContactCacheModel = new emailContactCacheModel();

		emailContactCacheModel.uuid = getUuid();

		String uuid = emailContactCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			emailContactCacheModel.uuid = null;
		}

		emailContactCacheModel.id = getId();

		emailContactCacheModel.nome = getNome();

		String nome = emailContactCacheModel.nome;

		if ((nome != null) && (nome.length() == 0)) {
			emailContactCacheModel.nome = null;
		}

		emailContactCacheModel.email = getEmail();

		String email = emailContactCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			emailContactCacheModel.email = null;
		}

		emailContactCacheModel.mensagem = getMensagem();

		String mensagem = emailContactCacheModel.mensagem;

		if ((mensagem != null) && (mensagem.length() == 0)) {
			emailContactCacheModel.mensagem = null;
		}

		emailContactCacheModel.status = getStatus();

		return emailContactCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", nome=");
		sb.append(getNome());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", mensagem=");
		sb.append(getMensagem());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("ama.opengov.model.emailContact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nome</column-name><column-value><![CDATA[");
		sb.append(getNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mensagem</column-name><column-value><![CDATA[");
		sb.append(getMensagem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = emailContact.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			emailContact.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _id;
	private String _nome;
	private String _originalNome;
	private String _email;
	private String _mensagem;
	private boolean _status;
	private long _columnBitmask;
	private emailContact _escapedModel;
}