package io.github.emircakmakgil.orderservice.model.enums;

public enum OrderStatus {
    PENDING,        // Beklemede (Ödeme bekleniyor)
    PROCESSING,     // İşleniyor (Hazırlık aşaması)
    SHIPPED,        // Kargoya Verildi
    DELIVERED,      // Teslim Edildi
    CANCELLED       // İptal Edildi
}