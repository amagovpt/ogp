package pt.ama.services.customuser.api;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

//import AMA.OpenGov.samlProtocol.api.model.AuthType;
import AMA.OpenGov.samlProtocol.api.model.SamlBean;
//import pt.ama.services.common.exceptions.EmptyFieldException;
import pt.ama.services.customuser.model.CustomUserModel;

/**
 * @author Gfi
 */
public interface CustomUserService {
	
	User getUser(SamlBean bean, long companyId);
	
//	CustomUserModel getUser(long userId);
//	
//	boolean deleteUser(long userId, long companyId);
//	
//	boolean updateUser(long userId, AuthType authType, SamlBean bean, long companyId) throws EmptyFieldException, PortalException;
//
	User createUser(long userCreatorID, long companyId, long groupId, String screenName, SamlBean bean, String agreeFullName, String agreePortalUseData, String agreeEmail);
//	
	void updateUserAuthType(long userCreatorID, String authenticationType);
//	
//	AuthType getUserAuthenticationType(long userId);

	
}