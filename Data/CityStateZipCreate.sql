/****** Object:  Table [dbo].[CityStateZip]    Script Date: 02/27/2019 11:52:39 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[CityStateZip](
	[CityStateZip_ID] [int] IDENTITY(1,1) NOT NULL,
	[City_str] [varchar](50) NULL,
	[State_str] [varchar](50) NOT NULL,
	[StateAbbr_str] [char](2) NULL,
	[Zipcode_str] [char](5) NULL,
	[ZipCodeType] [varchar](50) NULL,
	[LocationType] [varchar](50) NULL,
	[Lat] [varchar](50) NULL,
	[Long] [varchar](50) NULL,
	[Xaxis] [varchar](50) NULL,
	[Yaxis] [varchar](50) NULL,
	[Zaxis] [varchar](50) NULL,
	[Country] [varchar](50) NULL,
	[Decommisioned] [bit] NOT NULL,
 CONSTRAINT [PK_free-zipcode-databaseFormatted] PRIMARY KEY CLUSTERED 
(
	[CityStateZip_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON, FILLFACTOR = 80) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[CityStateZip] ADD  CONSTRAINT [DF_CityStateZip_State_str]  DEFAULT ('') FOR [State_str]
GO

ALTER TABLE [dbo].[CityStateZip] ADD  CONSTRAINT [DF_CityStateZip_Country]  DEFAULT ('USA') FOR [Country]
GO

ALTER TABLE [dbo].[CityStateZip] ADD  CONSTRAINT [DF_CityStateZip_Decommisioned]  DEFAULT ((0)) FOR [Decommisioned]
GO