package com.tibtof.empoweringproperties.ft.account

import org.hibernate.validator.constraints.Length
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.Valid
import javax.validation.constraints.NotNull

@ConditionalOnProperty(name = ["empowering-properties.feature.account.enabled"], havingValue = "true")
@RestController
@Validated
class AccountController(val accountRepository: AccountRepository) {

    @GetMapping("/accounts")
    fun getAccounts(@RequestParam clientId: Long) = accountRepository.findAllByClientId(clientId)

    @PostMapping("/accounts")
    fun createAccount(@Valid @RequestBody account: Account) = accountRepository.save(account)

}

@ConditionalOnProperty(name = ["empowering-properties.feature.account.enabled"], havingValue = "true")
@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun findAllByClientId(userId: Long): List<Account>
}

@Entity(name = "account")
class Account(@Id @GeneratedValue var id: Long?,
              @Column(length = 24, unique = true) @field:Length(min = 24, max = 24) var iban: String,
              @Column(length = 3) @field:Length(min = 3, max = 3) var currency: String,
              @Column @field:NotNull var balance: BigDecimal,
              @Column @field:NotNull var clientId: Long)

@ConditionalOnProperty(name = ["empowering-properties.feature.account.enabled"], havingValue = "true")
@Configuration
@EntityScan("com.tibtof.empoweringproperties.ft.account")
class AccountFeatureConfiguration
