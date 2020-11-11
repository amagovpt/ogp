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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing emailContact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see emailContact
 * @generated
 */
@ProviderType
public class emailContactCacheModel implements CacheModel<emailContact>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof emailContactCacheModel)) {
			return false;
		}

		emailContactCacheModel emailContactCacheModel = (emailContactCacheModel)obj;

		if (id == emailContactCacheModel.id) {
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
	public emailContact toEntityModel() {
		emailContactImpl emailContactImpl = new emailContactImpl();

		if (uuid == null) {
			emailContactImpl.setUuid(StringPool.BLANK);
		}
		else {
			emailContactImpl.setUuid(uuid);
		}

		emailContactImpl.setId(id);

		if (nome == null) {
			emailContactImpl.setNome(StringPool.BLANK);
		}
		else {
			emailContactImpl.setNome(nome);
		}

		if (email == null) {
			emailContactImpl.setEmail(StringPool.BLANK);
		}
		else {
			emailContactImpl.setEmail(email);
		}

		if (mensagem == null) {
			emailContactImpl.setMensagem(StringPool.BLANK);
		}
		else {
			emailContactImpl.setMensagem(mensagem);
		}

		emailContactImpl.setStatus(status);

		emailContactImpl.resetOriginalValues();

		return emailContactImpl;
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