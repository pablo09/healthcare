package com.pzeszko.healthcare.model;

/**
 * Created by Pawel on 2016-09-15.
 */
/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Objects;

@SuppressWarnings("serial")
@Embeddable
public class Money implements Serializable {

    public static final Currency DEFAULT_CURRENCY = Currency.getInstance("PLN");

    public static final Integer scale = 2;

    public static final Money ZERO = new Money(BigDecimal.ZERO);

    @Getter
    @Setter
    private BigDecimal denomination;

    @Getter
    @Setter
    private String currencyCode;

    @Deprecated
    protected Money() {
    }

    public Money(BigDecimal denomination, Currency currency) {
        this(denomination, currency.getCurrencyCode());
    }

    private Money(BigDecimal denomination, String currencyCode) {
        this.denomination = denomination.setScale(scale, RoundingMode.HALF_UP);
        this.currencyCode = currencyCode;
    }


    public Money(BigDecimal denomination) {
        this(denomination, DEFAULT_CURRENCY);
    }

    public Money(String denomination) {
        this(new BigDecimal(denomination), DEFAULT_CURRENCY);
    }


    public Money multiplyBy(BigDecimal multiplier) {
        return new Money(denomination.multiply(multiplier), currencyCode);
    }

    public Money add(Money money) {
        if (!compatibleCurrency(money)) {
            throw new IllegalArgumentException("Currency mismatch");
        }

        return new Money(denomination.add(money.denomination), determineCurrencyCode(money));
    }

    public Money subtract(Money money) {
        if (!compatibleCurrency(money))
            throw new IllegalArgumentException("Currency mismatch");

        return new Money(denomination.subtract(money.denomination), determineCurrencyCode(money));
    }

    /**
     * Currency is compatible if the same or either money object has zero value.
     */
    private boolean compatibleCurrency(Money money) {
        return isZero(denomination) || isZero(money.denomination) || currencyCode.equals(money.getCurrencyCode());
    }

    private boolean isZero(BigDecimal testedValue) {
        return BigDecimal.ZERO.compareTo(testedValue) == 0;
    }

    /**
     * @return currency from this object or otherCurrencyCode. Preferred is the
     * one that comes from LocalMoney that has non-zero value.
     */
    private Currency determineCurrencyCode(Money otherMoney) {
        String resultingCurrenctCode = isZero(denomination) ? otherMoney.currencyCode : currencyCode;
        return Currency.getInstance(resultingCurrenctCode);
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public Currency getCurrency() {
        return Currency.getInstance(currencyCode);
    }

    public boolean greaterThan(Money other) {
        return denomination.compareTo(other.denomination) > 0;
    }

    public boolean lessThan(Money other) {
        return denomination.compareTo(other.denomination) < 0;
    }

    public boolean lessOrEquals(Money other) {
        return denomination.compareTo(other.denomination) <= 0;
    }

    @Override
    public String toString() {
        return String.format("%0$.2f %s", denomination, getCurrency().getSymbol());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
        result = prime * result + ((denomination == null) ? 0 : denomination.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Money other = (Money) obj;
        return compatibleCurrency(other) && Objects.equals(denomination, other.denomination);
    }

    public Money exchange(BigDecimal exchangeRateToPln, Currency currency) {
        return new Money(denomination.multiply(exchangeRateToPln), currency);
    }

}
