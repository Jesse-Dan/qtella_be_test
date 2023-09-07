package qtella.com.qtella_backend.exceptions

class UserAlreadyExistException constructor(override val message: String?, override val cause: Throwable?): Exception()
class PasswordWrongException constructor(override val message: String?, override val cause: Throwable?): Exception()
class UserDoesNotExistException constructor(override val message: String?, override val cause: Throwable?): Exception()
class UserUnKnownError constructor(override val message: String?, override val cause: Throwable?): Exception()