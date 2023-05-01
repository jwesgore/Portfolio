-- 2a --
select S.city, I.color, C.cName, F.price
from Sales F, Store S, Item I, Customer C
where F.storeID = S.storeID and F.itemID = I.itemID 
and F.custID = C.custID and S.state = 'CA' 
and I.category = 'Tshirt' and C.age < 22 and F.price < 25;

-- 2b --
select storeID, cName, sum(price)
from Sales s, Customer c
where s.custID=c.custID
group by storeID, cName;

-- 2c --
select storeID, i.category, cName, sum(price)
from Sales s, Customer c, Item i
where s.custID=c.custID and s.itemID=i.itemID
group by storeID, i.category, cName;

-- 2d --
select s.storeID, i.category, cName, sum(price)
from Sales s, Customer c, Item i, Store t
where s.custID=c.custID and s.itemID=i.itemID
and s.storeID=t.storeID and t.storeId ='store6'
group by storeID, i.category, cName;

-- 2e --
select s.storeID, i.category, cName, sum(price)
from Sales s, Customer c, Item i, Store t
where s.custID=c.custID and s.itemID=i.itemID
and s.storeID=t.storeID and t.storeId ='store6' and i.category='Jacket'
group by storeID, i.category, cName;

-- 2f --
select i.category, sum(price)
from Sales s, Customer c, Item i, Store t
where s.custID=c.custID and s.itemID=i.itemID and s.storeID=t.storeID
group by i.category;

-- 2g --
select state, county, city, sum(price)
from Sales F, Store S
where F.storeID = S.storeID
group by state, county, city;

-- 2h -- 
select state, county, city, sum(price)
from Sales F, Store S
where F.storeID = S.storeID
group by state, county, city with rollup;

-- 3a --
select state, age, sum(price) from Store st, Sales sa, Customer c 
where sa.storeID = st.storeID and sa.custID=c.custID 
group by state, age;

-- 3b --
select state, age, color, sum(price) 
from Store st, Sales sa, Customer c, Item i
where sa.storeID = st.storeID and sa.custID=c.custID and sa.itemID = i.itemID
group by state, age, color;

-- 3c --
select state, age, color, sum(price) 
from Store st, Sales sa, Customer c, Item i
where sa.storeID = st.storeID and sa.custID=c.custID and sa.itemID = i.itemID
group by state, age, color with rollup;

-- 3d --
select state, age, color, sum(price) 
from Store st, Sales sa, Customer c, Item i
where sa.storeID = st.storeID and sa.custID=c.custID and sa.itemID = i.itemID and i.color = "blue"
group by state, age, color;

-- 3e --
select age, color, sum(price) 
from Sales sa, Customer c, Item i
where sa.custID=c.custID and sa.itemID = i.itemID
group by age, color with rollup;
