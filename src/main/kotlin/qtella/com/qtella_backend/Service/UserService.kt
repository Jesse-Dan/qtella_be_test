package qtella.com.qtella_backend.Service

import org.springframework.stereotype.Service
import qtella.com.qtella_backend.DataSource.mock.UserMockDataResources
import qtella.com.qtella_backend.model.LoginPayload
import qtella.com.qtella_backend.model.User


@Service
class UserService (val resources: UserMockDataResources) {

    fun addUser(user: User)=resources.createAccount(user = user)

    fun logIn(loginPayload: LoginPayload) = resources.login(loginPayload = loginPayload)


}