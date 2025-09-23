USE currency;

SELECT * FROM currency;

SELECT * FROM currency WHERE abbreviation = 'EUR';

SELECT COUNT(*) AS currency_count FROM currency;

SELECT * FROM currency ORDER BY conversion_rate_to_EUR DESC LIMIT 1;