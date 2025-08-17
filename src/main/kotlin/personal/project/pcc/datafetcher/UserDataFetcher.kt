package personal.project.pcc.datafetcher

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import personal.project.pcc.model.User
import personal.project.pcc.service.UserService

@DgsComponent
class UserDataFetcher(private val userService: UserService) {
    @DgsQuery
    fun serverInfo(): String = "DGS up; in-memory store"

    @DgsQuery
    fun user(@InputArgument id: String): User? = userService.get(id)

    @DgsQuery
    fun users(): List<User> = userService.listUsers()
}
