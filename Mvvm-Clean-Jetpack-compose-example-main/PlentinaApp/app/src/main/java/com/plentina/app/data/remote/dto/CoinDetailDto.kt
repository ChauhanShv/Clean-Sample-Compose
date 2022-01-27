package com.plentina.app.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.plentina.app.domain.model.CoinDetail

data class CoinDetailDto(
    val description: String?,
    @SerializedName("development_status")
    val developmentStatus: String?,
    @SerializedName("first_data_at")
    val firstDataAt: String?,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean?,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String?,
    val id: String?,
    @SerializedName("is_active")
    val isActive: Boolean?,
    @SerializedName("is_new")
    val isNew: Boolean?,
    @SerializedName("last_data_at")
    val lastDataAt: String?,
    @SerializedName("links")
    val links: Links?,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("open_source")
    val openSource: Boolean?,
    @SerializedName("org_structure")
    val orgStructure: String?,
    @SerializedName("started_at")
    val startedAt: String?,
    @SerializedName("symbol")
    val symbol: String?,
    val tags: List<Tag>?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("whitepaper")
    val whitepaper: Whitepaper?,
    @SerializedName("proof_type")
    val proofType: String?,
    val rank: Int
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags?.map { it.name },
    )
}