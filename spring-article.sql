-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.13-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table article.articles
CREATE TABLE IF NOT EXISTS `articles` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(95) NOT NULL DEFAULT '0',
  `content` text NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Dumping data for table article.articles: ~7 rows (approximately)
/*!40000 ALTER TABLE `articles` DISABLE KEYS */;
INSERT INTO `articles` (`id`, `title`, `content`) VALUES
	(1, 'How to avoid these 6 mitsakes when applying for grants in Singapore', 'Rated number one in the world by the World Bank for ease of doing business, Singapore provides a variety of grants. In its most recent budget, the city-stateÃ¢ÂÂs government amplified its support toward the tech sector through a number of publicly funded schemes.\r\n\r\nStill, many tech companies are currently missing out on the opportunity to benefit from these grants. We take a look at some of the main slip-ups.'),
	(2, 'StashAway banks $5.3m funding, but road to profitability for robo-advisors remains unclear', 'Over the past few years, Singapore has seen the birth of several fintech startups that are using automation and AI to replicate the role of human financial advisors, helping users to preserve and grow their wealth through passive investing.\r\n\r\nWith lower fees than banks and fund managers, these robo-advisors reckon they can make more money for their users than their offline competitors. But the more pressing question for them and their backers is, how can they can make money for themselves while operating with razor-thin margins?\r\n\r\nOne of this new crop of robo-advisors, StashAway, announced today that it has raised US$5.3 million in its series A round.'),
	(3, 'Asia news roundup: Flipkart losses widen to $3.6b, Toutiao and Weibo duke it out, and mores', 'FlipkartÃÂÃÂ¢ÃÂÃÂÃÂÃÂs losses equate to half its venture funding (India). The Indian ecommerce firm has raised about US$6.1 billion since launching 10 years ago. But regulatory filings in Singapore suggest that as of March last year, its accumulated losses widened to US$3.6 billion  from US$1.53 billion a year previously. It was reported last week that US retail giant Walmart is closing in on a US$7 billion stake in Flipkart. (Bloomberg)\r\n\r\nAlibaba might be buying Rocket InternetÃÂÃÂ¢ÃÂÃÂÃÂÃÂs Pakistan business (Pakistan/China). The Chinese tech giant is said to be negotiating a price for Daraz, RocketÃÂÃÂ¢ÃÂÃÂÃÂÃÂs Pakistani retail unit, in the latest sign of its interest in the country. It emerged last week that Alibaba affiliate Ant Financial invested US$185 million in Pakistani mobile financial services platform Telenor Microfinance Bank. (Bloomberg)'),
	(4, 'Alibaba and Twitter backer makes first-ever India bet', 'Growth-stage venture capital and private equity firm Insight Venture Partners, an investor in several high-profile software-as-a-service (SaaS) companies like Shopify, NewRelic, and Wix, today revealed its first investment in India: subscription billing software-maker Chargebee.\r\n\r\nThe New York-based investor led Chargebeeâs US$18 million series C round of funding, in which existing investors Accel Partners and Tiger Global Management participated. Insight, which has raised over US$18 billion in capital, has invested in more than 300 companies worldwide, including Hootsuite, Flipboard, Twitter, JD, and Alibaba. Chennai-based Chargebee caught its eye at the SaaStr conference in San Francisco a year ago.'),
	(5, 'Will esports boom in Southeast Asia like it did in China?', 'Discuss features short but strong and insightful opinions on interesting startup, entrepreneurship, and tech topics. Got a topic or question to suggest? Drop us an email or leave a comment.\r\n\r\nThe esports market in China is huge. With 16 percent of the global total in 2017, it is the second-biggest gaming market after North America. The rise of mobile esports can boost it even further.\r\n\r\nWill we see this kind of growth in all of Southeast Asia? Is the esports industry worth investing in if we look at long-term growth? We asked a couple of investors for their thoughts.'),
	(6, '4 startup lessons I learned from Alibabaâs founders program', 'I was very excited to have been offered the opportunity to attend the e-Founders fellowship program at the Alibaba headquarters in China. My reasons for excitement were two-fold: it was a joint program between Alibaba Business School and United Nations Conference on Trade and Development (UNCTAD) and there was a chance to meet and learn from 36 other startup founders from Southeast Asia.'),
	(12, 'Behind SingaporeÃ¢ÂÂs meteoric rise as a top blockchain hub', 'Whichever tech circle in Singapore you move in, chances are youÃ¢ÂÂve heard about another exciting new initial coin offering (ICO) thatÃ¢ÂÂs launching. ICOs Ã¢ÂÂ also known as token sales Ã¢ÂÂ are fast becoming the great Gold Rush of the 21st century and, perhaps, the ultimate equalizers of fundraising. And Singapore has become the new California Dream for some intrepid blockchain explorers.');
/*!40000 ALTER TABLE `articles` ENABLE KEYS */;

-- Dumping structure for table article.comments
CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) unsigned DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `comment` text DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `FK_comments_articles` (`article_id`),
  KEY `FK_comments_users` (`user_id`),
  CONSTRAINT `FK_comments_articles` FOREIGN KEY (`article_id`) REFERENCES `articles` (`id`),
  CONSTRAINT `FK_comments_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table article.comments: ~3 rows (approximately)
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` (`id`, `article_id`, `user_id`, `comment`, `created_at`) VALUES
	(1, 1, 1, 'Hehehehehe', '2018-04-23 10:15:33'),
	(2, 1, 1, 'One to many implementation', '2018-04-23 10:17:17'),
	(3, 1, 1, 'lmaaoaoaoaoao', '2018-05-09 16:55:38');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;

-- Dumping structure for table article.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table article.hibernate_sequence: ~2 rows (approximately)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(7),
	(7);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table article.hibernate_sequences
CREATE TABLE IF NOT EXISTS `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table article.hibernate_sequences: ~0 rows (approximately)
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;

-- Dumping structure for table article.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` tinyint(2) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(65) DEFAULT '0',
  `alias` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table article.roles: ~2 rows (approximately)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `role_name`, `alias`) VALUES
	(1, 'Admin', 'ROLE_ADMIN'),
	(2, 'Author', 'ROLE_AUTHOR');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Dumping structure for table article.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(90) NOT NULL DEFAULT '0',
  `password` varchar(60) NOT NULL DEFAULT '0',
  `role_id` tinyint(2) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK_users_roles` (`role_id`),
  CONSTRAINT `FK_users_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table article.users: ~2 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `password`, `role_id`) VALUES
	(1, 'admin', '$2a$10$LRcuCJYCbtzvpkflwheuG.loMhTFR8W9ByaxXcBsv3Fb/IItWA4hK', 1),
	(2, 'author', '$2a$10$1YRA5xHxwiAFC.w/SSvOK.DWaU7o8FnwM1uY0tr7rPG.WJxY6SY/e', 2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
