select O.product_name
from CUSTOMERS C
         join ORDERS O on C.id = O.customer_id
where C.name = :name;