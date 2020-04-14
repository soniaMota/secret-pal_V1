provider "aws" {
  access_key = "AKIAYTZLSAXQK67BEBQ5"
  secret_key = "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"
  region = "eu-west-1"
}

resource "aws_vpc" "secret-pal" {
  cidr_block = "${var.vpc-fullcidr}"
  enable_dns_support = true
  enable_dns_hostnames = true
}
