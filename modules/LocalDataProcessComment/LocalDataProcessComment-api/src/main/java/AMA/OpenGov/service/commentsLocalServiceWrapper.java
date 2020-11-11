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

package AMA.OpenGov.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link commentsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see commentsLocalService
 * @generated
 */
@ProviderType
public class commentsLocalServiceWrapper implements commentsLocalService,
	ServiceWrapper<commentsLocalService> {
	public commentsLocalServiceWrapper(
		commentsLocalService commentsLocalService) {
		_commentsLocalService = commentsLocalService;
	}

	/**
	* Adds the comments to the database. Also notifies the appropriate model listeners.
	*
	* @param comments the comments
	* @return the comments that was added
	*/
	@Override
	public AMA.OpenGov.model.comments addcomments(
		AMA.OpenGov.model.comments comments) {
		return _commentsLocalService.addcomments(comments);
	}

	/**
	* Creates a new comments with the primary key. Does not add the comments to the database.
	*
	* @param id the primary key for the new comments
	* @return the new comments
	*/
	@Override
	public AMA.OpenGov.model.comments createcomments(long id) {
		return _commentsLocalService.createcomments(id);
	}

	/**
	* Deletes the comments from the database. Also notifies the appropriate model listeners.
	*
	* @param comments the comments
	* @return the comments that was removed
	*/
	@Override
	public AMA.OpenGov.model.comments deletecomments(
		AMA.OpenGov.model.comments comments) {
		return _commentsLocalService.deletecomments(comments);
	}

	/**
	* Deletes the comments with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the comments
	* @return the comments that was removed
	* @throws PortalException if a comments with the primary key could not be found
	*/
	@Override
	public AMA.OpenGov.model.comments deletecomments(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commentsLocalService.deletecomments(id);
	}

	@Override
	public AMA.OpenGov.model.comments fetchcomments(long id) {
		return _commentsLocalService.fetchcomments(id);
	}

	/**
	* Returns the comments with the primary key.
	*
	* @param id the primary key of the comments
	* @return the comments
	* @throws PortalException if a comments with the primary key could not be found
	*/
	@Override
	public AMA.OpenGov.model.comments getcomments(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commentsLocalService.getcomments(id);
	}

	/**
	* Updates the comments in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param comments the comments
	* @return the comments that was updated
	*/
	@Override
	public AMA.OpenGov.model.comments updatecomments(
		AMA.OpenGov.model.comments comments) {
		return _commentsLocalService.updatecomments(comments);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _commentsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commentsLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _commentsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commentsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commentsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of commentses.
	*
	* @return the number of commentses
	*/
	@Override
	public int getcommentsesCount() {
		return _commentsLocalService.getcommentsesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _commentsLocalService.getOSGiServiceIdentifier();
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
		return _commentsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMA.OpenGov.model.impl.commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _commentsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMA.OpenGov.model.impl.commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _commentsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the commentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMA.OpenGov.model.impl.commentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of commentses
	* @param end the upper bound of the range of commentses (not inclusive)
	* @return the range of commentses
	*/
	@Override
	public java.util.List<AMA.OpenGov.model.comments> getcommentses(int start,
		int end) {
		return _commentsLocalService.getcommentses(start, end);
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
		return _commentsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _commentsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public commentsLocalService getWrappedService() {
		return _commentsLocalService;
	}

	@Override
	public void setWrappedService(commentsLocalService commentsLocalService) {
		_commentsLocalService = commentsLocalService;
	}

	private commentsLocalService _commentsLocalService;
}