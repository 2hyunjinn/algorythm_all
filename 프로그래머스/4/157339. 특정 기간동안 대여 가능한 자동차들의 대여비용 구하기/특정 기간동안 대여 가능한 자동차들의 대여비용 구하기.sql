-- 2022-11-01 ~ 2022-11-30 동안 대여 가능한 '세단'/'SUV'
-- 30일 비용 = DAILY_FEE * 30 * (1 - (할인율))
-- 할인율은 DISCOUNT_PLAN에서 '30일 이상' 규칙 사용
SELECT
  c.CAR_ID,
  c.CAR_TYPE,
  FLOOR(c.DAILY_FEE * 30 * (1 - (CAST(REPLACE(dp.DISCOUNT_RATE, '%', '') AS DECIMAL(5,2)) / 100))) AS FEE
FROM CAR_RENTAL_COMPANY_CAR c
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN dp
  ON dp.CAR_TYPE = c.CAR_TYPE
 AND dp.DURATION_TYPE = '30일 이상'
WHERE c.CAR_TYPE IN ('세단', 'SUV')
  -- 기간 겹치면 대여 불가: (대여 시작 ≤ 조회 종료) AND (대여 종료 ≥ 조회 시작)
  AND NOT EXISTS (
    SELECT 1
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    WHERE h.CAR_ID = c.CAR_ID
      AND h.START_DATE <= '2022-11-30'
      AND h.END_DATE   >= '2022-11-01'
  )
-- FEE 별칭을 쓰기 위해 HAVING에서 금액 범위 필터
HAVING FEE >= 500000
   AND FEE <  2000000
ORDER BY
  FEE DESC,          -- 대여 금액 내림차순
  CAR_TYPE ASC,      -- 금액 같으면 자동차 종류 오름차순
  CAR_ID DESC;       -- 자동차 종류까지 같으면 CAR_ID 내림차순