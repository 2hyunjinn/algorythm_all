-- 코드를 입력하세요
-- 생산일자가 2022년 5월인 식품

SELECT p.PRODUCT_ID, p.PRODUCT_NAME, SUM(p.PRICE * o.AMOUNT) as TOTAL_SALES
from FOOD_PRODUCT p
join FOOD_ORDER o on p.PRODUCT_ID = o.PRODUCT_ID
where o.PRODUCE_DATE like '2022-05-%'
group by p.PRODUCT_ID
order by TOTAL_SALES desc, p.PRODUCT_ID;
