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

package AMA.OpenGov.model.impl;

import AMA.OpenGov.model.comments;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing comments in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see comments
 * @generated
 */
@ProviderType
public class commentsCacheModel implements CacheModel<comments>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof commentsCacheModel)) {
			return false;
		}

		commentsCacheModel commentsCacheModel = (commentsCacheModel)obj;

		if (id == commentsCacheModel.id) {
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

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", email=");
		sb.append(email);
		sb.append(", mensagem=");
		sb.append(mensagem);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public comments toEntityModel() {
		commentsImpl commentsImpl = new commentsImpl();

		if (uuid == null) {
			commentsImpl.setUuid(StringPool.BLANK);
		}
		else {
			commentsImpl.setUuid(uuid);
		}

		commentsImpl.setId(id);

		if (nome == null) {
			commentsImpl.setNome(StringPool.BLANK);
		}
		else {
			commentsImpl.setNome(nome);
		}

		if (email == null) {
			commentsImpl.setEmail(StringPool.BLANK);
		}
		else {
			commentsImpl.setEmail(email);
		}

		if (mensagem == null) {
			commentsImpl.setMensagem(StringPool.BLANK);
		}
		else {
			commentsImpl.setMensagem(mensagem);
		}

		commentsImpl.setStatus(status);

		commentsImpl.resetOriginalValues();

		return commentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		nome = objectInput.readUTF();
		email = objectInput.readUTF();
		mensagem = objectInput.readUTF();

		status = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

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
	}

	public String uuid;
	public long id;
	public String nome;
	public String email;
	public String mensagem;
	public boolean status;
}