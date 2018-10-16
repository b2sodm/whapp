/* 
 * whapp.sql
 */
/**
 * Author:  Brian
 * Created: 09 Oct 2018
 */

-- Database: whdb

-- DROP DATABASE whdb;

CREATE DATABASE whdb
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_South Africa.1252'
       LC_CTYPE = 'English_South Africa.1252'
       CONNECTION LIMIT = -1;

-- Table: public.tblcategory

-- DROP TABLE public.tblcategory;

CREATE TABLE public.tblcategory
(
  categoryid character varying(30) NOT NULL,
  categoryname character varying(30) NOT NULL,
  description character varying(99),
  picture character varying(99),
  CONSTRAINT tblcategory_pkey PRIMARY KEY (categoryid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tblcategory
  OWNER TO postgres;

-- Table: public.tblsupplier

-- DROP TABLE public.tblsupplier;

CREATE TABLE public.tblsupplier
(
  supplierid character varying(30) NOT NULL,
  companyname character varying(30) NOT NULL,
  contactname character varying(30) NOT NULL,
  contacttitle character varying(30),
  address character varying(99),
  city character varying(99),
  region character varying(99),
  postalcode character varying(30),
  country character varying(99),
  phone character varying(30),
  fax character varying(30),
  homepage character varying(30) NOT NULL,
  CONSTRAINT tblsupplier_pkey PRIMARY KEY (supplierid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tblsupplier
  OWNER TO postgres;

-- Table: public.tblproduct

-- DROP TABLE public.tblproduct;

CREATE TABLE public.tblproduct
(
  productid character varying(30) NOT NULL,
  productname character varying(30) NOT NULL,
  supplierid character varying(30) NOT NULL,
  categoryid character varying(30) NOT NULL,
  quantityperunit double precision,
  unitprice double precision,
  unitsinstock double precision,
  unitsonorder double precision,
  reorderlevel double precision,
  discontinued boolean,
  CONSTRAINT tblproduct_pkey PRIMARY KEY (productid),
  CONSTRAINT "tblproduct_CategoryID_fkey" FOREIGN KEY (categoryid)
      REFERENCES public.tblcategory (categoryid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "tblproduct_SupplierID_fkey" FOREIGN KEY (supplierid)
      REFERENCES public.tblsupplier ("SupplierID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tblproduct
  OWNER TO postgres;

-- Table: public.tblorderdetail

-- DROP TABLE public.tblorderdetail;

CREATE TABLE public.tblorderdetail
(
  orderid character varying(30) NOT NULL,
  productid character varying(30) NOT NULL,
  unitprice double precision,
  quantity double precision,
  discount double precision,
  CONSTRAINT tblorderdetail_pkey PRIMARY KEY (orderid, productid),
  CONSTRAINT "tblorderdetail_ProductID_fkey" FOREIGN KEY (productid)
      REFERENCES public.tblproduct ("ProductID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tblorderdetail
  OWNER TO postgres;
