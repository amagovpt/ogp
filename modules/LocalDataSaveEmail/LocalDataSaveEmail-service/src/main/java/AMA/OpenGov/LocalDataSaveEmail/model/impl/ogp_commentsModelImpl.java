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

package AMA.OpenGov.LocalDataSaveEmail.model.impl;

import AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments;
import AMA.OpenGov.LocalDataSaveEmail.model.ogp_commentsModel;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ogp_comments service. Represents a row in the &quot;AMA_ogp_comments&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ogp_commentsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ogp_commentsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ogp_commentsImpl
 * @see ogp_comments
 * @see ogp_commentsModel
 * @generated
 */
@ProviderType
public class ogp_commentsModelImpl extends BaseModelImpl<ogp_comments>
	implements ogp_commentsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ogp_comments model instance should use the {@link ogp_comments} interface instead.
	 */
	public static final String TABLE_NAME = "AMA_ogp_comments";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "nome", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "mensagem", Types.VARCHAR },
			{ "status", Types.BOOLEAN },
			{ "date_", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nome", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mensagem", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("date_", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table AMA_ogp_comments (id_ LONG not null primary key,nome VARCHAR(75) null,email VARCHAR(75) null,mensagem VARCHAR(75) null,status BOOLEAN,date_ DATE null)";
	public static final String TABLE_SQL_DROP = "drop table AMA_ogp_comments";
	public static final String ORDER_BY_JPQL = " ORDER BY ogp_comments.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY AMA_ogp_comments.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(AMA.OpenGov.LocalDataSaveEmail.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(AMA.OpenGov.LocalDataSaveEmail.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(AMA.OpenGov.LocalDataSaveEmail.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments"),
			true);
	public static final long NOME_COLUMN_BITMASK = 1L;
	public static final long ID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(AMA.OpenGov.LocalDataSaveEmail.service.util.ServiceProps.get(
				"lock.expiration.time.AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments"));

	public ogp_commentsModelImpl() {
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_columnBitmask = -1L;

		_id = id;
	}

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

	@Override
	public boolean getStatus() {
		return _status;
	}

	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		_status = status;
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ogp_comments.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ogp_comments toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ogp_comments)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ogp_commentsImpl ogp_commentsImpl = new ogp_commentsImpl();

		ogp_commentsImpl.setId(getId());
		ogp_commentsImpl.setNome(getNome());
		ogp_commentsImpl.setEmail(getEmail());
		ogp_commentsImpl.setMensagem(getMensagem());
		ogp_commentsImpl.setStatus(getStatus());
		ogp_commentsImpl.setDate(getDate());

		ogp_commentsImpl.resetOriginalValues();

		return ogp_commentsImpl;
	}

	@Override
	public int compareTo(ogp_comments ogp_comments) {
		int value = 0;

		if (getId() < ogp_comments.getId()) {
			value = -1;
		}
		else if (getId() > ogp_comments.getId()) {
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

		if (!(obj instanceof ogp_comments)) {
			return false;
		}

		ogp_comments ogp_comments = (ogp_comments)obj;

		long primaryKey = ogp_comments.getPrimaryKey();

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
		ogp_commentsModelImpl ogp_commentsModelImpl = this;

		ogp_commentsModelImpl._originalNome = ogp_commentsModelImpl._nome;

		ogp_commentsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ogp_comments> toCacheModel() {
		ogp_commentsCacheModel ogp_commentsCacheModel = new ogp_commentsCacheModel();

		ogp_commentsCacheModel.id = getId();

		ogp_commentsCacheModel.nome = getNome();

		String nome = ogp_commentsCacheModel.nome;

		if ((nome != null) && (nome.length() == 0)) {
			ogp_commentsCacheModel.nome = null;
		}

		ogp_commentsCacheModel.email = getEmail();

		String email = ogp_commentsCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			ogp_commentsCacheModel.email = null;
		}

		ogp_commentsCacheModel.mensagem = getMensagem();

		String mensagem = ogp_commentsCacheModel.mensagem;

		if ((mensagem != null) && (mensagem.length() == 0)) {
			ogp_commentsCacheModel.mensagem = null;
		}

		ogp_commentsCacheModel.status = getStatus();

		Date date = getDate();

		if (date != null) {
			ogp_commentsCacheModel.date = date.getTime();
		}
		else {
			ogp_commentsCacheModel.date = Long.MIN_VALUE;
		}

		return ogp_commentsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", nome=");
		sb.append(getNome());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", mensagem=");
		sb.append(getMensagem());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", date=");
		sb.append(getDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments");
		sb.append("</model-name>");

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
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ogp_comments.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ogp_comments.class
		};
	private long _id;
	private String _nome;
	private String _originalNome;
	private String _email;
	private String _mensagem;
	private boolean _status;
	private Date _date;
	private long _columnBitmask;
	private ogp_comments _escapedModel;
}