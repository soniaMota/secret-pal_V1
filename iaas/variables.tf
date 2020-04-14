variable "region" {
  default = "eu-west-1"
}

variable "AmiLinux" {
  default = "ami-0047bb1e28a00e0d1"
}

variable "aws_access_key" {
  default = "AKIAYTZLSAXQK67BEBQ5"
  description = "the user aws access key"
}

variable "aws_secret_key" {
  default = "c/lAZtcMB0EOHf+xRLwfxnfNvmtB0KoT6cKaSd+p"
  description = "the user aws secret key"
}

variable "vpc-fullcidr" {
  default = "172.28.0.0/16"
  description = "the vpc cdir"
}

variable "Subnet-Public-AzA-CIDR" {
  default = "172.28.0.0/24"
  description = "the cidr of the subnet"
}

variable "Subnet-Private-AzA-CIDR" {
  default = "172.28.3.0/24"
  description = "the cidr of the subnet"
}

variable "key_name" {
  default = "estudio"
  description = "the ssh key to use in the EC2 machines"
}

variable "DnsZoneName" {
  default = "secret-pal.internal"
  description = "the internal dns name"
}
