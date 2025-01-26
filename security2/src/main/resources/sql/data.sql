-- users 테이블에 데이터 삽입
INSERT IGNORE INTO `spring2`.`users` (id, username, password, algorithm)
VALUES
  (1, 'danny.kim', '$2a$10$KcE2ZV52mbpV3q4eikTXXe320oZy0v9agU8lfQTJUj6HyWE41BRqi', 'BCRYPT'),
  (2, 'steve.kim', '$2a$10$KcE2ZV52mbpV3q4eikTXXe320oZy0v9agU8lfQTJUj6HyWE41BRqi', 'BCRYPT');
INSERT IGNORE INTO `spring2`.`users` (id, username, password, algorithm)
VALUES (3, 'new_user', '$2a$10$examplepasswordhash', 'BCRYPT');
-- authorities 테이블에 데이터 삽입
INSERT IGNORE INTO `spring2`.`authorities` (id, name, user_entity)
VALUES
  (1, 'READ', 1),
  (2, 'WRITE', 1),
  (3, 'READ', 2);

-- products 테이블에 데이터 삽입 (price를 숫자로 처리할 경우 DECIMAL 등 사용 권장)
INSERT IGNORE INTO `spring2`.`products` (id, name, price, currency)
VALUES
  (1, 'Chocolate', '10', 'USD');