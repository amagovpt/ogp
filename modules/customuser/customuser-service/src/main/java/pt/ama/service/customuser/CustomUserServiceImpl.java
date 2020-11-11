package pt.ama.service.customuser;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

//import AMA.OpenGov.samlProtocol.api.model.AuthType;
import AMA.OpenGov.samlProtocol.api.model.SamlBean;
//import pt.ama.service.db.entities.exception.NoSuchUserPersonalDataException;
//import pt.ama.service.db.entities.model.UserPersonalData;
import pt.ama.service.db.entities.service.UserPersonalDataLocalService;
//import pt.ama.services.common.exceptions.EmptyFieldException;
import pt.ama.services.customuser.api.CustomUserService;
//import pt.ama.services.customuser.enums.FieldsEnum;
import pt.ama.services.customuser.exceptions.UserAlreadyExistsException;
import pt.ama.services.customuser.model.CustomUserModel;

/***
 * 
 * @author Gfi
 */
@Component(
		immediate = true, 
			property = {
		}, 
		service = CustomUserService.class
)
public class CustomUserServiceImpl implements CustomUserService {

	@Reference
	UserPersonalDataLocalService userPersonalDataLocalService;

	@Reference
	UserLocalService userLocalService;
	
	private final Log _log = LogFactoryUtil.getLog(CustomUserServiceImpl.class);

	@Override
	public User createUser(long userCreatorID, long companyId, long groupId, String screenName, SamlBean bean, String agreeFullName, String agreePortalUseData, String agreeEmail) {
		return userPersonalDataLocalService.createUser(userCreatorID, companyId, groupId, screenName, bean.getFirstName(),
				bean.getLastName(), bean.getNic(), bean.getNoa(), bean.getNon(), bean.getNcs(), bean.getPassport(),
				bean.getEmailAddress(), bean.getNationality(), agreeFullName, agreePortalUseData, agreeEmail);
	}

	private User findUserByIdentificationId(String identificationId) {
		return userPersonalDataLocalService.getUserByIdentificationId(identificationId);
	}

	@Override
	public User getUser(SamlBean bean, long companyId) {

		User user = null;
		_log.info("Passando pelo CustomUsers");
//		_log.info("authType user para buscar:"+ authType);
//		switch (authType) {
//		case CC:
			
			_log.info("bean.getNic() CC:::"+bean.getNic());
			_log.info("Autenticação CC:::"+findUserByIdentificationId(bean.getNic()));
			_log.info("Codigo NIC:"+(bean.getNic()));
			
			user = findUserByIdentificationId(bean.getNic());
//			break;
//		case CMD_NIC:
//			user = findUserByIdentificationId(bean.getNic());
//			break;
//		case CMD_PASSPORT:
//			user = findUserByPassportId(bean.getPassport(), bean.getNationality());
//			break;
//		case LAWYER:
//			user = findUserByLawerId(bean.getNoa());
//			break;
//		case NOTARY:
//			user = findUserByNotaryId(bean.getNon());
//			break;
//		case SIMPLE:
//			user = findUserByEmailAddress(companyId, bean.getEmailAddress());
//			break;
//		case SOCIAL_NETWORK:
//			user = findUserByIdentificationId(bean.getNic());
//			break;
//		case SOLICITATOR:
//			user = findUserBySolicitorId(bean.getNcs());
//			break;
//		}
//		_log.info("Autenticação CC:::CustomUser"+user);
		return user;
	}

//	@Override
//	public CustomUserModel getUser(long userId) {
//
//		CustomUserModel customUserModel = new CustomUserModel();
//
//		UserPersonalData upd = userPersonalDataLocalService.getUserById(userId);
//
//		try {
//			User user = userLocalService.getUser(userId);
//
//			customUserModel.setFullName(user.getFullName());
//
//			if (user.isEmailAddressVerified()) {
//				customUserModel.setEmail(user.getEmailAddress());
//			}
//			if (upd != null) {
//				customUserModel.setIdentificationId(upd.getIdentificationId());
//				customUserModel.setLawerId(upd.getLawerId());
//				customUserModel.setNotaryId(upd.getNotaryId());
//				customUserModel.setPassportId(upd.getPassportId());
//				customUserModel.setSolicitorId(upd.getSolicitorId());
//			}
//		} catch (Exception e) {
//			_log.error(e.getMessage(), e);
//		}
//		return customUserModel;
//	}

//	public boolean deleteUser(long userId, long companyId) {
//
//		boolean success;
//
//		try {
//			success = userPersonalDataLocalService.deleteUser(userId, companyId);
//		} catch (NoSuchUserPersonalDataException ue) {
//			success = false;
//			ue.printStackTrace();
//		} catch (PortalException pe) {
//			success = false;
//			_log.warn(pe.getMessage(), pe);
//		}
//
//		return success;
//	}

//	@Override
//	public boolean updateUser(long userId, AuthType authType, SamlBean bean, long companyId)
//			throws UserAlreadyExistsException, EmptyFieldException, PortalException {
//		// TODO implement SOCIAL_NETWORK
//			User user = userLocalService.getUser(userId);
//			UserPersonalData userPersonalData;
//			try {
//				userPersonalData = userPersonalDataLocalService.getUserPersonalData(userId);
//			} catch (Exception e) {
//				userPersonalData = userPersonalDataLocalService.createUserPersonalData(userId);
//			}
//			if (authType.equals(AuthType.CC) || authType.equals(AuthType.CMD_NIC) || authType.equals(AuthType.NOTARY)
//					|| authType.equals(AuthType.LAWYER) || authType.equals(AuthType.SOLICITATOR)
//					|| authType.equals(AuthType.CMD_PASSPORT)) {
//				if (bean.getFirstName() == null)
//					throw new EmptyFieldException(FieldsEnum.FIRST_NAME);
//				if (bean.getLastName() == null)
//					throw new EmptyFieldException(FieldsEnum.LAST_NAME);
//				user.setFirstName(bean.getFirstName());
//				user.setLastName(bean.getLastName());
//			}
//			if (authType.equals(AuthType.CC) || authType.equals(AuthType.CMD_NIC)) {
//				if (bean.getNic() == null)
//					throw new EmptyFieldException(FieldsEnum.NIC);
//				if (userPersonalDataLocalService.getUserByIdentificationId(bean.getNic()) != null)
//					throw new UserAlreadyExistsException(FieldsEnum.NIC);
//				userPersonalData.setIdentificationId(bean.getNic());
//				if (bean.getEmailAddress() != null) {
//					user.setEmailAddress(bean.getEmailAddress());
//					user.setEmailAddressVerified(true);
//				}
//			}
//			if (authType.equals(AuthType.NOTARY)) {
//				if (bean.getNon() == null)
//					throw new EmptyFieldException(FieldsEnum.NON);
//				if (userPersonalDataLocalService.getUserByNotaryId(bean.getNon()) != null)
//					throw new UserAlreadyExistsException(FieldsEnum.NON);
//				userPersonalData.setNotaryId(bean.getNon());
//			}
//			if (authType.equals(AuthType.LAWYER)) {
//				if (bean.getNoa() == null)
//					throw new EmptyFieldException(FieldsEnum.NOA);
//				if (userPersonalDataLocalService.getUserByLawerId(bean.getNoa()) != null)
//					throw new UserAlreadyExistsException(FieldsEnum.NOA);
//				userPersonalData.setLawerId(bean.getNoa());
//			}
//			if (authType.equals(AuthType.SOLICITATOR)) {
//				if (bean.getNcs() == null)
//					throw new EmptyFieldException(FieldsEnum.NCS);
//				if (userPersonalDataLocalService.getUserBySolicitorId(bean.getNcs()) != null)
//					throw new UserAlreadyExistsException(FieldsEnum.NCS);
//				userPersonalData.setSolicitorId(bean.getNcs());
//			}
//			if (authType.equals(AuthType.CMD_PASSPORT)) {
//				if (bean.getPassport() == null)
//					throw new EmptyFieldException(FieldsEnum.PASSPORT);
//				if (bean.getNationality() == null)
//					throw new EmptyFieldException(FieldsEnum.NATIONALITY);
//				if (userPersonalDataLocalService.getUserByPassport(bean.getPassport(), bean.getNationality()) != null)
//					throw new UserAlreadyExistsException(FieldsEnum.PASSPORT);
//				userPersonalData.setNationality(bean.getNationality());
//				userPersonalData.setPassportId(bean.getPassport());
//				if (bean.getEmailAddress() != null) {
//					user.setEmailAddress(bean.getEmailAddress());
//					user.setEmailAddressVerified(true);
//				}
//			}
//			if (authType.equals(AuthType.NOTARY) || authType.equals(AuthType.LAWYER)
//					|| authType.equals(AuthType.SOLICITATOR) || authType.equals(AuthType.SIMPLE)) {
//				if (bean.getEmailAddress() == null)
//					throw new EmptyFieldException(FieldsEnum.EMAIL);
//				if (authType.equals(AuthType.SIMPLE)) {
//					if (userPersonalDataLocalService.getUserByEmailAddress(companyId, bean.getEmailAddress()) != null)
//						throw new UserAlreadyExistsException(FieldsEnum.EMAIL);
//				}
//				user.setEmailAddress(bean.getEmailAddress());
//				user.setEmailAddressVerified(true);
//			}
//			userLocalService.updateUser(user);
//			userPersonalDataLocalService.updateUserPersonalData(userPersonalData);
//			
//			return true;
//	}
	
	public void updateUserAuthType(long userId, String authenticationType)
	{
		
		User user = null;
		try {
			user = userLocalService.getUser(userId);
		} catch (PortalException e1) {
			_log.info("erro updateUserAuthType:" + e1);
		}
		//ravel - ataulização do user.
		user.setPasswordReset(false);
		user.setStatus(0);
		user.setReminderQueryAnswer("UTILIZADOR CRIADO PELO OPENGOV");
		userLocalService.updateUser(user);
		
		try {
			User user2 = userLocalService.getUser(userId);
			_log.info("pass;;;;;"+ user2.getPasswordReset());
			_log.info("setReminderQueryAnswer;;;;;"+ user2.getReminderQueryAnswer());
			_log.info("setReminderQueryAnswer;;;;;"+ user2.getStatus());
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_log.info("fim do updateUserAuthType fun");
	}
	
//	public AuthType getUserAuthenticationType(long userId)
//	{
//		String value = userPersonalDataLocalService.getUserAuthenticationType(userId);
//		
//		AuthType authType = null;
//		
//		if (value != null && value != "")
//		{
//			try
//			{
//				authType = AuthType.valueOf(value);
//			}
//			catch(Exception e)
//			{
//				_log.error(e);
//			}
//		}
//		
//		return authType;
//	}

}