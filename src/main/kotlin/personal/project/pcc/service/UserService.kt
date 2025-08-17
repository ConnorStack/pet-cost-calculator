package personal.project.pcc.service

import org.springframework.stereotype.Service
import personal.project.pcc.model.User
import java.util.concurrent.ConcurrentHashMap

@Service
class UserService {
    private val store = ConcurrentHashMap<String, User>().apply {
        put("1", User(1, "Leia Organa", "leia@rebellion.org"))
        put("2", User(2, "Din Djarin", "mando@navarro.space"))
    }

    fun get(id: String): User? = store[id]

    fun listUsers(): List<User> = store.values.sortedBy { it.id }
}