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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the emailContact service. Represents a row in the &quot;email_contact&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see emailContactModel
 * @see bd.ama.model.impl.emailContactImpl
 * @see bd.ama.model.impl.emailContactModelImpl
 * @generated
 */
@ImplementationClassName("bd.ama.model.impl.emailContactImpl")
@ProviderType
public interface emailContact extends emailContactModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link bd.ama.model.impl.emailContactImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<emailContact, Long> ID_ACCESSOR = new Accessor<emailContact, Long>() {
			@Override
			public Long get(emailContact emailContact) {
				return emailContact.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<emailContact> getTypeClass() {
				return emailContact.class;
			}
		};
}