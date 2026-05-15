
CREATE TABLE alert_rule (
    id BIGSERIAL PRIMARY KEY,
    ticker VARCHAR(20) NOT NULL,
    price_condition VARCHAR(50) NOT NULL,
    target_price DECIMAL(19, 4) NOT NULL,
    status VARCHAR(50) NOT NULL,
    triggered_at TIMESTAMPTZ NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255),

    CONSTRAINT fk_alert_rule_user FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_alert_rule_user_id ON alert_rule(user_id);
CREATE INDEX idx_alert_rule_ticker ON alert_rule(ticker);
