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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ogp_comments in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ogp_comments
 * @generated
 */
@ProviderType
public class ogp_commentsCacheModel implements CacheModel<ogp_comments>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ogp_commentsCacheModel)) {
			return false;
		}

		ogp_commentsCacheModel ogp_commentsCacheModel = (ogp_commentsCacheModel)obj;

		if (id == ogp_commentsCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", email=");
		sb.append(email);
		sb.append(", mensagem=");
		sb.append(mensagem);
		sb.append(", status=");
		sb.append(status);
		sb.append(", date=");
		sb.append(date);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ogp_comments toEntityModel() {
		ogp_commentsImpl ogp_commentsImpl = new ogp_commentsImpl();

		ogp_commentsImpl.setId(id);

		if (nome == null) {
			ogp_commentsImpl.setNome(StringPool.BLANK);
		}
		else {
			ogp_commentsImpl.setNome(nome);
		}

		if (email == null) {
			ogp_commentsImpl.setEmail(StringPool.BLANK);
		}
		else {
			ogp_commentsImpl.setEmail(email);
		}

		if (mensagem == null) {
			ogp_commentsImpl.setMensagem(StringPool.BLANK);
		}
		else {
			ogp_commentsImpl.setMensagem(mensagem);
		}

		ogp_commentsImpl.setStatus(status);

		if (date == Long.MIN_VALUE) {
			ogp_commentsImpl.setDate(null);
		}
		else {
			ogp_commentsImpl.setDate(new Date(date));
		}

		ogp_commentsImpl.resetOriginalValues();

		return ogp_commentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		nome = objectInput.readUTF();
		email = objectInput.readUTF();
		mensagem = objectInput.readUTF();

		status = objectInput.readBoolean();
		date = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (nome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (mensagem == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mensagem);
		}

		objectOutput.writeBoolean(status);
		objectOutput.writeLong(date);
	}

	public long id;
	public String nome;
	public String email;
	public String mensagem;
	public boolean status;
	public long date;
}