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

package bd.ama.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link emailContactLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see emailContactLocalService
 * @generated
 */
@ProviderType
public class emailContactLocalServiceWrapper implements emailContactLocalService,
	ServiceWrapper<emailContactLocalService> {
	public emailContactLocalServiceWrapper(
		emailContactLocalService emailContactLocalService) {
		_emailContactLocalService = emailContactLocalService;
	}

	/**
	* Adds the email contact to the database. Also notifies the appropriate model listeners.
	*
	* @param emailContact the email contact
	* @return the email contact that was added
	*/
	@Override
	public bd.ama.model.emailContact addemailContact(
		bd.ama.model.emailContact emailContact) {
		return _emailContactLocalService.addemailContact(emailContact);
	}

	/**
	* Creates a new email contact with the primary key. Does not add the email contact to the database.
	*
	* @param id the primary key for the new email contact
	* @return the new email contact
	*/
	@Override
	public bd.ama.model.emailContact createemailContact(long id) {
		return _emailContactLocalService.createemailContact(id);
	}

	/**
	* Deletes the email contact from the database. Also notifies the appropriate model listeners.
	*
	* @param emailContact the email contact
	* @return the email contact that was removed
	*/
	@Override
	public bd.ama.model.emailContact deleteemailContact(
		bd.ama.model.emailContact emailContact) {
		return _emailContactLocalService.deleteemailContact(emailContact);
	}

	/**
	* Deletes the email contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email contact
	* @return the email contact that was removed
	* @throws PortalException if a email contact with the primary key could not be found
	*/
	@Override
	public bd.ama.model.emailContact deleteemailContact(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _emailContactLocalService.deleteemailContact(id);
	}

	@Override
	public bd.ama.model.emailContact fetchemailContact(long id) {
		return _emailContactLocalService.fetchemailContact(id);
	}

	/**
	* Returns the email contact with the primary key.
	*
	* @param id the primary key of the email contact
	* @return the email contact
	* @throws PortalException if a email contact with the primary key could not be found
	*/
	@Override
	public bd.ama.model.emailContact getemailContact(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _emailContactLocalService.getemailContact(id);
	}

	/**
	* Updates the email contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param emailContact the email contact
	* @return the email contact that was updated
	*/
	@Override
	public bd.ama.model.emailContact updateemailContact(
		bd.ama.model.emailContact emailContact) {
		return _emailContactLocalService.updateemailContact(emailContact);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _emailContactLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emailContactLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _emailContactLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _emailContactLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _emailContactLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of email contacts.
	*
	* @return the number of email contacts
	*/
	@Override
	public int getemailContactsCount() {
		return _emailContactLocalService.getemailContactsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _emailContactLocalService.getOSGiServiceIdentifier();
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
		return _emailContactLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bd.ama.model.impl.emailContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _emailContactLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bd.ama.model.impl.emailContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _emailContactLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the email contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bd.ama.model.impl.emailContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of email contacts
	* @param end the upper bound of the range of email contacts (not inclusive)
	* @return the range of email contacts
	*/
	@Override
	public java.util.List<bd.ama.model.emailContact> getemailContacts(
		int start, int end) {
		return _emailContactLocalService.getemailContacts(start, end);
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
		return _emailContactLocalService.dynamicQueryCount(dynamicQuery);
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
		return _emailContactLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public emailContactLocalService getWrappedService() {
		return _emailContactLocalService;
	}

	@Override
	public void setWrappedService(
		emailContactLocalService emailContactLocalService) {
		_emailContactLocalService = emailContactLocalService;
	}

	private emailContactLocalService _emailContactLocalService;
}