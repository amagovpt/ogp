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

package pt.ama.service.db.entities.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the UserPersonalData service. Represents a row in the &quot;ogp_UserPersonalData&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserPersonalDataModel
 * @see pt.ama.service.db.entities.model.impl.UserPersonalDataImpl
 * @see pt.ama.service.db.entities.model.impl.UserPersonalDataModelImpl
 * @generated
 */
@ImplementationClassName("pt.ama.service.db.entities.model.impl.UserPersonalDataImpl")
@ProviderType
public interface UserPersonalData extends UserPersonalDataModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link pt.ama.service.db.entities.model.impl.UserPersonalDataImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserPersonalData, Long> USER_ID_ACCESSOR = new Accessor<UserPersonalData, Long>() {
			@Override
			public Long get(UserPersonalData userPersonalData) {
				return userPersonalData.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserPersonalData> getTypeClass() {
				return UserPersonalData.class;
			}
		};
}