package cloudburst.plugins.editwebhooks.utils

data class Webhook(
    val type: Int?,
    val avatar: String?,
    val token: String?,
    val name: String?,
    val id: String?,
    val source_guild: Source?,
    val source_channel: Source?
) {
    val url: String
        get() {
            return "https://discord.com/api/webhooks/%s/%s".format(id, token)
        }
    val avatarUrl: String
        get() {
            return "https://cdn.discordapp.com/avatars/%s/%s.webp".format(id, avatar)
        }
    val typeReadable: String
        get() {
            // https://discord.com/developers/docs/resources/webhook#webhook-object-webhook-types
            if (type == 1)
                return "Incoming"
            else if (type == 2)
                return "Channel Follower"
            else if (type == 3)
                return "Application"
            else
                return "Unknown"
        }
}

data class Source(
    val id: Long,
    val name: String
)