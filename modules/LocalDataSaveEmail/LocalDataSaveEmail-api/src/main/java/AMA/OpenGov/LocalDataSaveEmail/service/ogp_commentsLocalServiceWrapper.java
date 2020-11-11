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

package AMA.OpenGov.LocalDataSaveEmail.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ogp_commentsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ogp_commentsLocalService
 * @generated
 */
@ProviderType
public class ogp_commentsLocalServiceWrapper implements ogp_commentsLocalService,
	ServiceWrapper<ogp_commentsLocalService> {
	public ogp_commentsLocalServiceWrapper(
		ogp_commentsLocalService ogp_commentsLocalService) {
		_ogp_commentsLocalService = ogp_commentsLocalService;
	}

	/**
	* Adds the ogp_comments to the database. Also notifies the appropriate model listeners.
	*
	* @param ogp_comments the ogp_comments
	* @return the ogp_comments that was added
	*/
	@Override
	public AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments addogp_comments(
		AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments ogp_comments) {
		return _ogp_commentsLocalService.addogp_comments(ogp_comments);
	}

	/**
	* Creates a new ogp_comments with the primary key. Does not add the ogp_comments to the database.
	*
	* @param id the primary key for the new ogp_comments
	* @return the new ogp_comments
	*/
	@Override
	public AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments createogp_comments(
		long id) {
		return _ogp_commentsLocalService.createogp_comments(id);
	}

	/**
	* Deletes the ogp_comments from the database. Also notifies the appropriate model listeners.
	*
	* @param ogp_comments the ogp_comments
	* @return the ogp_comments that was removed
	*/
	@Override
	public AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments deleteogp_comments(
		AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments ogp_comments) {
		return _ogp_commentsLocalService.deleteogp_comments(ogp_comments);
	}

	/**
	* Deletes the ogp_comments with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ogp_comments
	* @return the ogp_comments that was removed
	* @throws PortalException if a ogp_comments with the primary key could not be found
	*/
	@Override
	public AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments deleteogp_comments(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _ogp_commentsLocalService.deleteogp_comments(id);
	}

	@Override
	public AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments fetchogp_comments(
		long id) {
		return _ogp_commentsLocalService.fetchogp_comments(id);
	}

	/**
	* Returns the ogp_comments with the primary key.
	*
	* @param id the primary key of the ogp_comments
	* @return the ogp_comments
	* @throws PortalException if a ogp_comments with the primary key could not be found
	*/
	@Override
	public AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments getogp_comments(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _ogp_commentsLocalService.getogp_comments(id);
	}

	/**
	* Updates the ogp_comments in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ogp_comments the ogp_comments
	* @return the ogp_comments that was updated
	*/
	@Override
	public AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments updateogp_comments(
		AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments ogp_comments) {
		return _ogp_commentsLocalService.updateogp_comments(ogp_comments);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _ogp_commentsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ogp_commentsLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _ogp_commentsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ogp_commentsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ogp_commentsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of ogp_commentses.
	*
	* @return the number of ogp_commentses
	*/
	@Override
	public int getogp_commentsesCount() {
		return _ogp_commentsLocalService.getogp_commentsesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _ogp_commentsLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _ogp_commentsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMA.OpenGov.LocalDataSaveEmail.model.impl.ogp_commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _ogp_commentsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMA.OpenGov.LocalDataSaveEmail.model.impl.ogp_commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _ogp_commentsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the ogp_commentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMA.OpenGov.LocalDataSaveEmail.model.impl.ogp_commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ogp_commentses
	* @param end the upper bound of the range of ogp_commentses (not inclusive)
	* @return the range of ogp_commentses
	*/
	@Override
	public java.util.List<AMA.OpenGov.LocalDataSaveEmail.model.ogp_comments> getogp_commentses(
		int start, int end) {
		return _ogp_commentsLocalService.getogp_commentses(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _ogp_commentsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _ogp_commentsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ogp_commentsLocalService getWrappedService() {
		return _ogp_commentsLocalService;
	}

	@Override
	public void setWrappedService(
		ogp_commentsLocalService ogp_commentsLocalService) {
		_ogp_commentsLocalService = ogp_commentsLocalService;
	}

	private ogp_commentsLocalService _ogp_commentsLocalService;
}