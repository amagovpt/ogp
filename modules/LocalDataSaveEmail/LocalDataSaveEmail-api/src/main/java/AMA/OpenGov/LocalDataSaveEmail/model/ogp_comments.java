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

package AMA.OpenGov.LocalDataSaveEmail.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the ogp_comments service. Represents a row in the &quot;AMA_ogp_comments&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ogp_commentsModel
 * @see AMA.OpenGov.LocalDataSaveEmail.model.impl.ogp_commentsImpl
 * @see AMA.OpenGov.LocalDataSaveEmail.model.impl.ogp_commentsModelImpl
 * @generated
 */
@ImplementationClassName("AMA.OpenGov.LocalDataSaveEmail.model.impl.ogp_commentsImpl")
@ProviderType
public interface ogp_comments extends ogp_commentsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link AMA.OpenGov.LocalDataSaveEmail.model.impl.ogp_commentsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ogp_comments, Long> ID_ACCESSOR = new Accessor<ogp_comments, Long>() {
			@Override
			public Long get(ogp_comments ogp_comments) {
				return ogp_comments.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ogp_comments> getTypeClass() {
				return ogp_comments.class;
			}
		};
}